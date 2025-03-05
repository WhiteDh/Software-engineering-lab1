let socket = new SockJS('/websocket');
let stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    console.log("Connected to WebSocket", frame);

    stompClient.subscribe('/topic/counter', function (message) {
        let counterUpdate = JSON.parse(message.body);
        document.getElementById('counter').innerText = counterUpdate.counter;
    });

    stompClient.send("/app/getCounter", {}, JSON.stringify({}));
});

document.addEventListener('DOMContentLoaded', function() {
    const btn = document.getElementById('increment-btn');
    btn.addEventListener('click', function () {
        stompClient.send("/app/increment", {}, JSON.stringify({}));
    });
});
