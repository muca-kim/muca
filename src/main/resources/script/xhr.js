class XHR{

    constructor(xhr){
        this.xhr = xhr;
    }

    get(url){
        fetch(url, json).then(res => {
            return res.json();
        });
    }

    post(url){
        fetch(url, {
            method: "POST"
        }).then(res => {
            return res.json();
        });
    }
}
// export default this.XHR;
