let bodyhtml=document.body;
let listhtml=document.getElementById('table');
let html='';
for(let i=1;i<=9;i++){
    html+=`<tr>`;
  //  listhtml.innerHTML+='<tr>';
    for(let j=1;j<=9;j++){
        if(j<=i){
            html+=`<td>${i}*${j}</td>`;
     //       listhtml.innerHTML+=`<td>${i}*${j}</td>`;
        }
    } 
     html+=`</tr>`;
 // listhtml.innerHTML+='</tr>';
}
 listhtml.innerHTML=html;
$('document').ready(function(){
    $('td').click(function(){
        let text=$(this)[0].innerText;
        let x=text.split('*')[0];
        let y=text.split('*')[1];
        alert(`${x}*${y}=${x*y}`);
    })
});
//listhtml.innerHTML+=`<tr><td>???</td></tr>`;
//console.log(listhtml.innerHTML);
