window.onload=function(){stats();}

 dataset=[];
function stats() {
    console.log("Hello world");
    var data=JSON.stringify({"genre":"abc"});
    var xhr = new XMLHttpRequest();
   // xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function() {
         if(this.readyState === 4) {
              console.log(this.responseText);
              let data = JSON.parse(this.responseText);
                    console.log("Anime Name:" + data.Population);
                    console.log("Anime Name:" + data.TotalCases);
                    //dataset.push(data.Population)
                    dataset.push(data.TotalCases);
                    dataset.push(data.CasesToday);
                    dataset.push(data.PeopleCritical); 
                    dataset.push(data.TotalDeaths);
                    dataset.push(data.AffectedCountries);  
                    dataset.push(data.TotalPeopleRecovered);
                    console.log(dataset);
                    chartget();
                   
             }
     });

     xhr.open("POST", "https://covidstats2020.herokuapp.com/info");
     xhr.setRequestHeader("Accept", "application/json");
     xhr.setRequestHeader("Content-Type", "application/json");
     xhr.send(data);

 }
 console.log(dataset);
 
 

 function chartget()
 {
    let myChart = document.getElementById('myChart').getContext('2d');
  datavalues=dataset;
 
    // Global Options
    Chart.defaults.global.defaultFontFamily = 'Lato';
    Chart.defaults.global.defaultFontSize = 12;
    Chart.defaults.global.defaultFontColor = '#9FE29B';
    
    let massPopChart = new Chart(myChart, {
      type:'pie', // bar, horizontalBar, pie, line, doughnut, radar, polarArea
      data:{
        labels:['Total Cases', 'Cases Today', 'People Critical', 'Total Deaths', 'Affected Countries', 'Total People Recovered'],
        datasets:[{
          label:'',
          data:datavalues,
          //backgroundColor:'green',
          backgroundColor:[
            'rgba(255, 99, 132, 0.6)',
            'rgba(29, 209, 38, 0.95)',
            'rgba(75, 192, 192, 0.6)',
            'rgba(190, 23, 26, 0.95)',
            'rgba(153, 102, 255, 0.6)',
            'rgba(255, 159, 64, 0.6)',
            'rgba(255, 99, 132, 0.6)'
          ],
          borderWidth:1,
          borderColor:'#777',
          hoverBorderWidth:3,
          hoverBorderColor:'#000'
        }]
      },
      options:{
        title:{
          display:true,
          text:'Live Statistics',
          fontSize:80
        },
        legend:{
          display:true,
          position:'left',
          labels:{
            fontColor:'#F7F7F7'
          }
        },
        layout:{
          padding:{
            left:50,
            right:0,
            bottom:0,
            top:0
          }
        },
        tooltips:{
          enabled:true
        }
      }
    });
 }
