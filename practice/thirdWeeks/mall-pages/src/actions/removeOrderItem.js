import request from 'superagent';

const removeOrderItem = (orderId, orderItemId)=> {
    request.del('/orders/' + orderId + "/orderitems/" + orderItemId)
            .end((err, res)=> {
                if(res && res.statusCode === 204){
                    console.log("成功删除");
                }
            })
  };

export default removeOrderItem;