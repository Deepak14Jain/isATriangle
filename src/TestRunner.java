import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.Description;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    // ANSI escape codes
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";

    static class TestResult {
        String name;
        boolean passed;
        String message;

        TestResult(String name, boolean passed, String message) {
            this.name = name;
            this.passed = passed;
            this.message = message;
        }
    }

    public static void main(String[] args) {
        System.out.println(BOLD + CYAN + "📦 Running Unit Tests...\n" + RESET);

        JUnitCore junit = new JUnitCore();
        List<TestResult> results = new ArrayList<>();

        junit.addListener(new RunListener() {
            @Override
            public void testFinished(Description description) {
                results.add(new TestResult(description.getMethodName(), true, ""));
            }

            @Override
            public void testFailure(Failure failure) {
                results.removeIf(tr -> tr.name.equals(failure.getDescription().getMethodName()));
                results.add(new TestResult(failure.getDescription().getMethodName(), false, failure.getMessage()));
            }
        });

        long start = System.currentTimeMillis();
        Result result = junit.run(TriangleTest.class);
        long end = System.currentTimeMillis();

        printTable(results);
        printSummary(result, end - start);
    }

    private static void printTable(List<TestResult> results) {
        System.out.printf(BOLD + "%-50s %-10s %-40s\n" + RESET, "Test Name", "Status", "Message");
        System.out.println("=".repeat(100));

        for (TestResult tr : results) {
            String status = tr.passed ? GREEN + "PASS" + RESET : RED + "FAIL" + RESET;
            String message = tr.passed ? "" : tr.message;
            System.out.printf("%-50s %-19s %-31s\n", tr.name, status, message);
        }
        System.out.println();
    }

    private static void printSummary(Result result, long duration) {
        System.out.println(BOLD + YELLOW + "📊 Test Summary" + RESET);
        System.out.println("=".repeat(30));
        System.out.printf("Total Tests : %d\n", result.getRunCount());
        System.out.printf("Failures    : %s%d%s\n", result.getFailureCount() > 0 ? RED : GREEN, result.getFailureCount(), RESET);
        System.out.printf("Run Time    : %d ms\n", duration);

        if (result.wasSuccessful()) {
            System.out.println(GREEN + "\n🎉 All tests passed successfully!" + RESET);
        } else {
            System.out.println(RED + "\n❌ Some tests failed. Check messages above." + RESET);
        }
    }
}
