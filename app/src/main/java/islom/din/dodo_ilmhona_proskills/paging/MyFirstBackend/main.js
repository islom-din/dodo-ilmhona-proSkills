import express from "express";
import pkg from 'sqlite3';
const { Database } = pkg;


const PORT = 8080 
const app = express()

app.get('/pizzas',(req,res) => {

    let page = req.query.page;
    let limit = req.query.limit;

    console.log(page," & ", limit)

    const products = []
    let db = new Database("./main_db.db",(err) => {
        if (err) {
            console.log(err.message)
        }
    })
    db.all("SELECT * FROM products",function(err,rows){
        if(err){
            console.log(err.message)
        }

        let itarating_page = 0
        let itarating_limit = 0

        if (page != null) {
            rows.forEach(function(row){
            if (limit != null){
                if (itarating_limit % limit == 0){
                    itarating_page++
                }
            }else {
                if (itarating_limit % 10 == 0){
                    itarating_page++
                }
            }
            if (itarating_page == page){
                    products.push(row)
            }
            itarating_limit++
            })
        }else {
            rows.forEach(function(row){
                // console.log(row)
                products.push(row)
            })
        }
        
        res.send(products)
        db.close()
    })
})
app.listen(PORT,() => {
    console.log("Server runs at 8080 port")
})