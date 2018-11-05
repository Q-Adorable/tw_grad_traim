import React from 'react';
import Todo from './Todo';
import {shallow} from 'enzyme';
import '../testSetup'

it('renders without crashing', () => {
    const item = {label: 'test', completed: true};
    const component = shallow(<Todo item={item}/>);


    expect(component.find('label').text()).toBe('test');
    expect(component.find("input.edit").props().value).toBe('test');
    expect(component.find("li").hasClass('completed')).toBe(true);

});

it('should invoke handleClick when click destroy button', function () {
    const obj = {
        fn: () => {
        }
    };
    const spy = spyOn(obj, 'fn');
    const item = {label: 'test', completed: true};
    const wrapper = shallow(<Todo item={item} onDestroy={spy}/>);

    wrapper.find("button").simulate('click');

    expect(spy).toHaveBeenCalled();
});

it('should class contain editing when double click input.', function () {
    const item = {label: 'test', completed: true};
    const component = shallow(<Todo item={item}/>);


    expect(component.find("li").hasClass('editing')).toBe(false);

    component.setState({editing:true});
    expect(component.find("li").hasClass('editing')).toBe(true);

});

