const database = require('./datbase');

module.exports = function printInventory(inputs) {
    let cartItems = splitItems(inputs);
    let allItems = database.loadAllItems();
    let promotions = database.loadPromotions();
    let cartList = getAllItems(cartItems,allItems,promotions);
    console.log(printPlayList(cartList));
};

function splitItems(inputs){
    let cartItems = {};
    inputs.map(item => {
        if(item.includes('-')){
            let cart=item.split('-');
            cartItems[cart[0]]=parseInt(cart[1]);
        }else{
            if(cartItems[item] === undefined){
                cartItems[item]=0;
            }
            cartItems[item]+=1;
        } 
    })
  //  for(let key in cartItems){
  //      console.log(key + ' = ' + cartItems[key]);
  //  }
  return cartItems;    
}

function getAllItems(cartItems,allItems,promotions){
    let cartList=[];
    for(let barcode in cartItems){
        allItems.find(cart => {
            if(cart.barcode === barcode){
                let myCart={};
                myCart['barcode']=barcode;
                myCart['name']=cart.name;
                myCart['count']=cartItems[barcode];
                myCart['unit']=cart.unit;
                myCart['price']=cart.price;
                promotions.find(pro => {
                    if(pro.barcodes.includes(barcode) && myCart['count']>=3){
                        myCart['promotion']='yes';
                    }else{
                        myCart['promotion']='no';
                    }
                })

                cartList.push(myCart);
        //        console.log(myCart);
            }
        } )
    }
    return cartList;
   // console.log('有'+cartList.length+'件商品');
}

function printPlayList(cartList){
    let result = "***<没钱赚商店>购物清单***\n";
    let cartsTotal=0;
    let cartsProTotal=0;
    cartList.forEach(cart => {
        if(cart['promotion'] === 'yes'){
            let myCart = getPromotionItems(cart);
            cartsTotal += myCart['total'];
            cartsProTotal += myCart['promotionNumber']*myCart['price'];
            result += `名称：${myCart['name']}，数量：${myCart['count']}${myCart['unit']}，单价：${myCart['price'].toFixed(2)}(元)，小计：${myCart['total'].toFixed(2)}(元)\n`;
        }else{
            let myCart = getNoPromotionItems(cart);
            cartsTotal += myCart['total'];
            result += `名称：${myCart['name']}，数量：${myCart['count']}${myCart['unit']}，单价：${myCart['price'].toFixed(2)}(元)，小计：${myCart['total'].toFixed(2)}(元)\n`;
        }
    });
    result += '----------------------\n';
    result += '挥泪赠送商品：\n';
    cartList.forEach(cart => {
        if(cart['promotion'] === 'yes'){
            let myCart=getPromotionItems(cart);
            result += printPromotion(myCart);
        }
    });
    result += '----------------------\n';
    result += `总计：${cartsTotal.toFixed(2)}(元)\n`;
    result += `节省：${cartsProTotal.toFixed(2)}(元)\n`;
    result += '**********************';
    return result;
}

function getPromotionItems(myCart){
    let promotionNumber=parseInt(myCart['count']/3);
    let total = (myCart['count']-promotionNumber)*myCart['price'];
    myCart['promotionNumber']=promotionNumber;
    myCart['total']=total;
    return myCart;
}

function getNoPromotionItems(myCart){
    let total = myCart['count']*myCart['price'];
    myCart['total']=total;
    return myCart;
}

function printPromotion(proCart){
    return `名称：${proCart['name']}，数量：${proCart['promotionNumber']}${proCart['unit']}\n`;
}