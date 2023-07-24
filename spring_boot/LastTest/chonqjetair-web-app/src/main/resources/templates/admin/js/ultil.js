let suggestionsFrom = [];
let suggestionsTo = [];

$(document).ready(function () {
    $.ajax({
        url: "/api/v1/flights/airports",
        type: "GET",
        contentType: 'application/json',
        success: function (response) {
            response.forEach(function (item) {
                suggestionsFrom.push({ nation: item.nation, name: item.name });
                suggestionsTo.push({ nation: item.nation, name: item.name });
            });
            suggestionsFrom = removeDuplicates(suggestionsFrom);
            suggestionsTo = removeDuplicates(suggestionsTo);
            console.log(suggestionsFrom);
            console.log(suggestionsTo);
        },
        error: function (xhr, status, error) {
            console.log("not ok");
        }
    });
});
function convertToISO8601(dateTimeLocalString) {
    if (dateTimeLocalString===""){
        return ""
    }
    const dateTimeLocal = new Date(dateTimeLocalString);
    return dateTimeLocal.toISOString();
}
function convertDateToZonedDateTime(dateInput) {
    if (dateInput===""){
        return ""
    }
    const parts = dateInput.split('-');
    const year = parseInt(parts[0]);
    const month = parseInt(parts[1]);
    const day = parseInt(parts[2]);
    const dateObject = new Date(year, month - 1, day);
    const timezoneOffsetMinutes = dateObject.getTimezoneOffset();
    const timezoneOffsetMilliseconds = timezoneOffsetMinutes * 60 * 1000;
    const zonedDateTime = new Date(dateObject.getTime() + timezoneOffsetMilliseconds);

    return zonedDateTime.toISOString();
}

function convertTimestampToDate(timestamp) {
    const date = new Date(timestamp * 1000);
    return date.toLocaleString("vi-VN", {
        hour: "2-digit",
        minute: "2-digit",
        second: "2-digit",
        day: "2-digit",
        month: "2-digit",
        year: "numeric",
    });
}
function removeDuplicates(arr) {
    return arr.filter((item, index, self) => self.findIndex(i => i.nation === item.nation && i.name === item.name) === index);
}

const inputFieldFrom = $("#search-input-from");
const autocompleteListFrom = $(".autocomplete-list-from");

const inputFieldTo = $("#search-input-to");
const autocompleteListTo = $(".autocomplete-list-to");

function filterSuggestions(input, suggestions) {
    const lowerInput = input.toLowerCase();
    return suggestions.filter(suggestion => {
        const lowerNation = suggestion.nation.toLowerCase();
        const lowerName = suggestion.name.toLowerCase();
        return lowerNation.indexOf(lowerInput) !== -1 || lowerName.indexOf(lowerInput) !== -1;
    });
}


function updateAutocompleteList(input, suggestions, autocompleteList) {
    if (input.trim() === '') {
        autocompleteList.fadeOut();
        return;
    }

    const filteredSuggestions = filterSuggestions(input, suggestions);
    autocompleteList.empty();

    if (filteredSuggestions.length === 0) {
        const noResultItem = $("<li>No results found</li>");
        autocompleteList.append(noResultItem);
    } else {
        filteredSuggestions.forEach(suggestion => {
            const listItem = $("<li><p class='location'>" + suggestion.nation + "</p><p class='airport'>" + suggestion.name + "</p></li>");

            const nationIndex = suggestion.nation.toLowerCase().indexOf(input.toLowerCase());
            const nameIndex = suggestion.name.toLowerCase().indexOf(input.toLowerCase());

            if (nationIndex !== -1) {
                const highlightedNation = suggestion.nation.slice(0, nationIndex) + "<span class='highlight'>" + suggestion.nation.slice(nationIndex, nationIndex + input.length) + "</span>" + suggestion.nation.slice(nationIndex + input.length);
                listItem.find(".location").html(highlightedNation);
            }

            if (nameIndex !== -1) {
                const highlightedName = suggestion.name.slice(0, nameIndex) + "<span class='highlight'>" + suggestion.name.slice(nameIndex, nameIndex + input.length) + "</span>" + suggestion.name.slice(nameIndex + input.length);
                listItem.find(".airport").html(highlightedName);
            }
            autocompleteList.append(listItem);
        });
    }

    autocompleteList.fadeIn();
}

inputFieldFrom.on("input", function () {
    const input = inputFieldFrom.val();
    updateAutocompleteList(input, suggestionsFrom, autocompleteListFrom);
});

inputFieldTo.on("input", function () {
    const input = inputFieldTo.val();
    updateAutocompleteList(input, suggestionsTo, autocompleteListTo);
});

$(".autocomplete-list-from").on("click", "li", function () {
    const selectedValue = $(this).find(".location").text().split(',')[0].trim();
    inputFieldFrom.val(selectedValue);
    autocompleteListFrom.fadeOut();
});

$(".autocomplete-list-to").on("click", "li", function () {
    const selectedValue = $(this).find(".location").text().split(',')[0].trim();
    inputFieldTo.val(selectedValue);
    autocompleteListTo.fadeOut();
});