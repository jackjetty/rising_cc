//格式化时间
Date.prototype.toCommonCase=function(){
    var xYear=this.getYear();
    xYear=xYear+1900;
    
    var xMonth=this.getMonth()+1;
    if(xMonth<10){
        xMonth="0"+xMonth;
    }

    var xDay=this.getDate();
    if(xDay<10){
        xDay="0"+xDay;
    }

    var xHours=this.getHours();
    if(xHours<10){
        xHours="0"+xHours;
    }

    var xMinutes=this.getMinutes();
    if(xMinutes<10){
        xMinutes="0"+xMinutes;
    }

    var xSeconds=this.getSeconds();
    if(xSeconds<10){
        xSeconds="0"+xSeconds;
    }
    return xYear+"-"+xMonth+"-"+xDay+" "+xHours+":"+xMinutes+":"+xSeconds;
}