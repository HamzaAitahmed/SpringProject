let clicks = 0;

function onClickplus() {
    clicks += 1;
    document.getElementById("clicks").innerHTML = clicks;
}

function onClickminus() {
    clicks -= 1;
    document.getElementById("clicks").innerHTML = clicks;
}