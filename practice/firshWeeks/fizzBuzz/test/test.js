const FizzBuzz = require('../src/fizzBuzz');
const assert = require('assert');

describe('fizzBuzz ',() => {
    it('get result 1 given ',() => {
        let fizzBuzz=new FizzBuzz();
        assert.equal(fizzBuzz.getFizzBuzz(),'1');
    })
})