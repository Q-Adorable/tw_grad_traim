const initOrders = [];

const orders = (state = initOrders, action) => {
  let clone, order;
  switch(action.type){
    case 'INIT_ORDER':
      return action.data;
    case "UPDATE_OrderItem":
      if(action.productCount <= 0){
        return state;
      }
      clone = [...state];
      order = state.find(item => item.id === action.orderId);
      let orderItem = order.orderItems.find(item => item.id === action.orderItemId);
      orderItem.productCount = action.productCount;
      order.orderItems = [...order.orderItems];
      return clone;
    case "REMOVE_OrderItem":
      clone = [...state];
      order = state.find(item => item.id === action.orderId);
      order.orderItems = order.orderItems.filter(item => item.id !== action.orderItemId);
      if(order.orderItems.length === 0){
        clone = state.filter(item => item.id !== action.orderId);
      }
      return clone;
    default:
      return state;
  }
}
export default orders;