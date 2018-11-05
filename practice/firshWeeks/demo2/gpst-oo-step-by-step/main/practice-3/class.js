// Write your code here
module.exports = class Class {
    constructor(number){
        this.number=number;
    }
    assignLeader(student){
        this.leader=student.name;
        if(this.hasStudent === true){
            return 'Assign team leader successfully.';
        }
        return 'It is not one of us.'
    }
    appendMember(student){
        this.hasStudent=true;
    }
}