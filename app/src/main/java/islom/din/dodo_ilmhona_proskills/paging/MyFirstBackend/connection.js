// import pkg from 'sqlite3';
// const { Database } = pkg;

// // let db = new Database('./main_db',(err) => {
// //     if (err) {
// //         console.log(err.message)
// //     }
// //     console.log("connected ")

// //     const table = db.run('CREATE TABLE products(id INTERGER PRIMARY KEY,name text NOT NULL);',function(err) {
// //         if(err) {
// //             return console.log(err.message)
// //         }
// //         console.log('TABLE CREATED')
// //     })
// //     console.log(table)

// //     db.close((err) => {
// //         if(err) {
// //             console.log(err.message)
// //         }
// //     }) 
// //     console.log('main_db closed')
// // }) 

// let db = new Database("./main_db.db",(err) => {
//     if (err) {
//         console.log(err.message)
//     }
// })
// db.all("SELECT * FROM products",function(err,rows){
//     if(err){
//         console.log(err.message)
//     }
//     rows.forEach(function(row){
//         console.log(row)
//     })
// })
// db.close()
// console.log("DB closed")