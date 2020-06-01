function doSearch() {
    $("#pageForm").submit();
    parent.progress();
}

function changeProvince(id, cityId) {
    $("#cityIdSearch").empty();
    $('#cityIdSearch').append('<option value="">全部</option>');
    if(id){
        $.get(ctx.path +"/platform/common/getCityByProvinceId"+ ctx.noAuthSuffix +"?provinceId=" + id, function(data){
            console.log(JSON.stringify(data))
            for(var j=0;j<data.length;j++){
                if(cityId && cityId == data[j].cityId){
                    $('#cityIdSearch').append('<option selected value="'+data[j].cityId+'">'+data[j].cityName+'</option>');
                }else{
                    $('#cityIdSearch').append('<option value="'+data[j].cityId+'">'+data[j].cityName+'</option>');
                }
            }
        }, "json");
    }

}


