function generateBookFields(numOfBooks) {
    let bookFieldsContainer = document.getElementById('bookFieldsContainer');
    bookFieldsContainer.innerHTML = '';

    for (let i = 1; i <= numOfBooks; i++) {
        let bookField = '<div class="form-group">' +
            '<label for="book' + i + '">Sách thứ ' + i + ':</label>' +
            '<select class="form-control" id="book' + i + '" name="book' + i + '">' +
            '<option th:each="book : ${books}" th:value="${book.id}" th:text="${book.name}"></option>' +
            '</select>' +
            '</div>' +
            '<div class="form-group">' +
            '<label for="numOfDays' + i + '">Số ngày mượn sách thứ ' + i + ':</label>' +
            '<input type="number" class="form-control" id="numOfDays' + i + '" name="numOfDays' + i + '" min="1" max="30" required>' +
            '</div>';

        bookFieldsContainer.insertAdjacentHTML('beforeend', bookField);
    }
}