const os = require('os');
const path = require('path');

const sep = os.platform() === 'win32' ? ';' : ':';

const junit = path.join('lib', 'junit-4.13.2.jar');
const hamcrest = path.join('lib', 'hamcrest-core-1.3.jar');
const classes = path.join('out', 'production', 'IsATriangle');

const cp = [classes, junit, hamcrest].join(sep);
console.log(cp);
