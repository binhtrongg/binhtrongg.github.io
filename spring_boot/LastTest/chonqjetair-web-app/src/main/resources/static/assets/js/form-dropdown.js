// JavaScript
let sum = 1; // Đặt sum ban đầu là 1 để phù hợp với số hành khách ban đầu là 1

function addValue(a) {
    sum += a;
    if (sum < 0) sum = 1; // Đảm bảo tổng số hành khách không âm
    $('.final-count').text(`${sum} Passenger`);
}

let i = 1;
let y = 0;
let z = 0;

$('.btn-add').on('click touchstart', function () {
    const value = ++i;
    $('.pcount').text(`${value}`);
    addValue(1);
    event.stopPropagation();
    event.preventDefault();
});

$('.btn-subtract').on('click touchstart', function () {
    if (i === 1) {
        $(this).addClass('active');
        $('.pcount').text(1);
        addValue(0);
    } else {
        const value = --i;
        $('.pcount').text(`${value}`);
        addValue(-1);
    }
    event.stopPropagation();
    event.preventDefault();
});

$('.btn-add-c').on('click touchstart', function () {
    const value = ++y;
    $('.ccount').text(`${value}`);
    addValue(1);
    event.stopPropagation();
    event.preventDefault();
});

$('.btn-subtract-c').on('click touchstart', function () {
    if (y === 0) { // Nếu không còn crew (y === 0) thì không trừ được nữa
        $('.ccount').text(0);
    } else {
        const value = --y;
        $('.ccount').text(`${value}`);
        addValue(-1);
    }
    event.stopPropagation();
    event.preventDefault();
});

$('.btn-add-in').on('click touchstart', function () {
    const value = ++z;
    $('.incount').text(`${value}`);
    addValue(1);
    event.stopPropagation();
    event.preventDefault();
});

$('.btn-subtract-in').on('click touchstart', function () {
    if (z === 0) { // Nếu không còn infants (z === 0) thì không trừ được nữa
        $('.incount').text(0);
    } else {
        const value = --z;
        $('.incount').text(`${value}`);
        addValue(-1);
    }
    event.stopPropagation();
    event.preventDefault();
});
