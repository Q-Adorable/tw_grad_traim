import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {Provider} from 'react-redux';
import MyInput from './MyInput';
import store from './store';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(
    <Provider store={store}>
        <MyInput />
    </Provider>,document.getElementById('root'));
registerServiceWorker();
