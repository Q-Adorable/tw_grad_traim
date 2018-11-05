import store from './store'

describe('redux store',()=>{
    it('add todo',()=>{
        store.dispatch({
            type:'ADD_TODO',
            data:{
                text:'test1'
            }
        })
        let expectStore = {}
        expect(store.getState().todos).toEqual(expectStore);
    })
})