
$(".search-btn").click(function () {
    let flightName=$("#flight-search-name").val()
    let arrival= convertDateToZonedDateTime($("#arrival-time").val())
    let departure=convertDateToZonedDateTime($("#departure-time").val())
    let from=$("#search-input-from").val()
    let to=$("#search-input-to").val()

    let formdata={
        name:flightName,
        departureTime:departure,
        arrivalTime:arrival,
        from:from,
        to:to
    }


    console.log(formdata)
    $.ajax({
        url: "/api/v1/admin/flights/search",
        type: "POST",
        contentType: 'application/json',
        data:JSON.stringify(formdata),
        success: function (response) {
            console.log(response)
            renderFlights(response)
        },
        error: function (xhr, status, error) {
            console.log("not ok");
        }
    });
})
function renderFlights(flights) {
    const flightTable = $("#render-flight");
    flightTable.empty();

    if (!flights.length){
        flightTable.append(`<tr><td colspan="7"><p style="width: 100%;text-align: center;">Không Tìm Thấy Chuyến Bay Nào</p></td></tr>`)
    }

    flights.forEach(flight => {
        const html = `
      <tr>
        <td>${flight.name}</td>
        <td>${convertTimestampToDate(flight.departureTime)}</td>
        <td>${convertTimestampToDate(flight.arrivalTime)}</td>
        <td>${flight.origin.name}</td>
        <td>${flight.destination.name}</td>
        <td>
          <span class="rounded-100 py-4 px-10 text-center text-14 fw-500 bg-yellow-4 text-yellow-3">Confirmed</span>
        </td>
        <td>
          <div class="row x-gap-10 y-gap-10 items-center">
            <div class="col-auto">
              <button class="flex-center bg-light-2 rounded-4 size-35" data-bs-toggle="offcanvas" data-bs-target="#demo">
                <i class="icon-eye text-16 text-light-1"></i>
              </button>
            </div>
            <div class="col-auto">
              <button class="flex-center bg-light-2 rounded-4 size-35" onclick="deleteFlight(${flight.id})"">
                <i class="icon-edit text-16 text-light-1"></i>
              </button>
            </div>
            <div class="col-auto">
              <button class="flex-center bg-light-2 rounded-4 size-35">
                <i class="icon-trash-2 text-16 text-light-1"></i>
              </button>
            </div>
          </div>
        </td>
      </tr>
    `;

        flightTable.append(html);
    });
}

