import React, { Component } from 'react';
import {
  Container
} from 'reactstrap';
import NavContainer from './components/NavContainer';
import TabContainer from './components/TabContainer';

import './App.css'
const App = () => {
  return (
    <Container className="Container">
      <NavContainer />
      <TabContainer />
    </Container>
  );
}
export default App;