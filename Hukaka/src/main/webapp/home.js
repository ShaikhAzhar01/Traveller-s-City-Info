/**
 * 
 */
/**
 * 
 */  var images = ['https://www.sotc.in/blog/wp-content/uploads/2022/08/landscape-sandstone-mountains-with-river-green-valley-himalayas-nubra-valley-jammu-kashmir-india-2-1024x576.jpg', 'https://www.sotc.in/blog/wp-content/uploads/2022/08/Gulmarg-1.jpg', 'https://www.sotc.in/blog/wp-content/uploads/2022/08/betaab-valley.jpg', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/Taj_Mahal_%28Edited%29.jpeg/365px-Taj_Mahal_%28Edited%29.jpeg', 'https://assets.cntraveller.in/photos/631ad8301fa71362bb469133/16:9/w_1024%2Cc_limit/Lead-Image.jpg'];
        
        
        var currentIndex = 0;

       
        function changeBackground() {
            document.body.style.backgroundImage = 'url(' + images[currentIndex] + ')';
            currentIndex = (currentIndex + 1)
            if(currentIndex==5)
                currentIndex=0;
        }

        
        changeBackground();

       
        setInterval(changeBackground, 3000);