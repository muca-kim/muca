class XHR{

    constructor(xhr){
        this.xhr = xhr;
    }

    get(url, json){
        fetch(url, json).then(res => {
            return res.json();
        });
    }

    post(url, json){
        fetch(url, {
            method: "POST"
        }).then(res => {
            return res.json();
        });
    }
}
// export default this.XHR;
