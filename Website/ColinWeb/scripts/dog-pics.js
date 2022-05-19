let counter = 0;
window.onload = function(){
    let submit = document.getElementById('dogButton');
    submit.onclick = function(){
       if(counter == 8){
           counter = 0;
       }
       counter++;
       let imgSrc = `images/dogPics/dog${counter}.jpg`
       let dogPicture = document.getElementById('dogPicture')
       document.querySelector('#dogPicture').setAttribute('src', imgSrc);
    }
}