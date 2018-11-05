//mocha测试
const Person = require('../main/practice-3/person');
const Student = require('../main/practice-3/student');
const Teacher = require('../main/practice-3/teacher');
const Class = require('../main/practice-3/class');

const assert = require('assert');
describe('Array', function() {
  describe('#indexOf()', function() {
    it('should return -1 when the value is not present', function() {
      assert.equal([1,2,3].indexOf(4), -1);
    });
  });
});

describe("practice-3 Person", () => {
    it("should have field name and age", () => {
      let person = new Person("Tom", 21);
      assert.equal(person.name,"Tom");
      assert.equal(person.age,21);
    });
  
    it("should have a method introduce, introduce person with name and age", () => {
      let person = new Person("Tom", 21);
  
      let introduce = person.introduce();
  
      assert.equal(introduce,"My name is Tom. I am 21 years old.");
  
    });
  });
