import createStore from 'redux';

const reducer = (preState , action ) =>{
    if(action.type == 'ADD_TODO'){
        preState.data.push({text:'test1'});
    }
    return preState;
}

const store=createStore(reducer,todos);

export default store;