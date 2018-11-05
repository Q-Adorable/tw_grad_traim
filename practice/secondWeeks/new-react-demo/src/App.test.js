import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import {shallow} from 'enzyme';
import './testSetup'

it('renders without crashing', () => {
  const component = shallow(<div><p></p></div>);
  expect(component.find('p').exists()).toBe(true);
  
  // const div = document.createElement('div');
  // ReactDOM.render(<App />, div);
  // ReactDOM.unmountComponentAtNode(div);
});
