const initProducts = [];

const products = (state = initProducts, action) => {
  switch(action.type){
    case 'INIT_PRODUCT':
            return action.data;
    default:
      return state;
  }
}
export default products;