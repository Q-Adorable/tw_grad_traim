const fibonacci=require('../Fibonacci');
const assert=require('assert');

describe('fibonacci ',() => {
    describe('#of',()=>{
        it('shoult return 1 given 1',function(){
            let result=fibonacci.of(1);
            let expect=1;
            assert.deepEqual(expect,result);
        })
        it('shoult return 1 given 2',function(){
            let result=fibonacci.of(2);
            let expect=1;
            assert.deepEqual(expect,result);
        })
        it('shoult return 2 given 2',function(){
            let result=fibonacci.of(3) ;
            let expect=2;
            assert.deepEqual(expect,result);
        })
    })
})