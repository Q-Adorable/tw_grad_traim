import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import 'antd/dist/antd.css';
import AppRouter from './components/AppRouter';
import registerServiceWorker from './registerServiceWorker';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import reducers from './reducers';
import thunkMiddleware from 'redux-thunk';

const store = createStore(reducers,
  applyMiddleware(thunkMiddleware)
);

ReactDOM.render(
    <Provider store={store}>
        <AppRouter />
    </Provider>    
    , document.getElementById('root'));
registerServiceWorker();
