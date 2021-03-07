

get = async function (url, json) {
    url += `?json=${json}`;
    const response = await fetch(url, {
        method: "GET",
        headers: {
            'Content-Type': 'application/json'
        }
    });
    const obj = JSON.parse(await response.text());
    return obj;
};

post = async function (url, json) {
    let csrf = $("input[name='_csrf']").val();
    const response = await fetch(url, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrf
        },
        body: json
    });
    const obj = JSON.parse(await response.text());
    return obj;
};

// export default this.XHR;