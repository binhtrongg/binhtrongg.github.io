$(".search-flight-btn").click(function (event) {
    event.preventDefault()
    let from=$("#search-input-from").val()
    let to=$("#search-input-to").val()
    let departureTime=convertDateToZonedDateTime($("#oneway-journey-date").val())
    let arrivalTime=""
    let adult=$(".pcount").text()
    let chil=$(".ccount").text()
    let infan=$(".incount").text()
    let cabinClass=$(".select-cabin-class").val()
    let formdata={
        destination:from,
        origin:to,
        departureTime:departureTime,
        arrivalTime:arrivalTime,
        numAdults:adult,
        numChildren:chil,
        numInfants:infan,
        cabinClass:cabinClass
    }
    let queryString=$.param(formdata)
    console.log(formdata)
    $.ajax({
        url: "/flights-result?"+queryString,
        type: "GET",
        contentType: 'application/json',
        success: function (response) {
            console.log(response)
            location.href="http://localhost:8080/flights-result"
        },
        error: function (xhr, status, error) {
            console.log("not ok");
        }
    });
})