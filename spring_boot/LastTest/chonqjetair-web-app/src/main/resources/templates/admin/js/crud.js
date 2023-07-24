$(document).ready(function () {
    $(".save-flight-btn").click(function (event) {
        event.preventDefault()
        let name=$("#flight-create-name").val();
        let departureTime=$("#flight-create-departure-time").val();
        let arrivalTime=$("#flight-create-arrival-time").val()
        let isoDepartureTime = convertToISO8601(departureTime);
        let isoArrivalTime = convertToISO8601(arrivalTime);
        let origin=$("#mySelectOrigin").val()
        let destination=$("#mySelectDestination").val()
        let aircraftType=$("#mySelectAircraft").val()
        let formdata={
            name:name,
            departureTime:isoDepartureTime,
            arrivalTime:isoArrivalTime,
            aircraftTypeId:aircraftType,
            originId:origin,
            destinationId:destination
        }
        $.ajax({
            url:"/api/v1/flights",
            type:"POST",
            contentType: 'application/json',
            data:JSON.stringify(formdata),
            success: function (response) {
                alert("ok")
            },
            error: function (xhr, status, error) {
                alert("notOk")
            }
        })
    })
})

