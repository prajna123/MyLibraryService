import React, { Component } from 'react';
import Axios from 'axios';
import './App.css'


class App extends Component {

  constructor(){
    super();
    this.state={
      libraries:[],
      books:[],
      selectedLibrary:null
    }
  }

  componentDidMount(){
    Axios.get('http://localhost:8080/app/libraries')
      .then(response=>{
        this.setState({
          libraries: response.data
        })
      })
  }
  getBookDetails = lib => (e) => {
    this.setState({books:lib.books, selectedLibrary:lib.libraryName})
  }
  render () {
    
    return (
      
      <div class="App">
        <style>{"table{width: 50%;font-family: arial, sans-serif; border-collapse: collapse;} td, th {border: 1px solid #dddddd;text-align: centre;padding: 8px;} "}</style>
        
        {this.state.libraries.length>0?(
          <div>
            <div>
              <table>
                <tr>
                  <th width="15%">Library Name</th>
                  <th width="15%">Address</th>
                  <th width="15%">Show Books</th>
                </tr>
              </table>
            </div>
            {this.state.libraries.map((val)=>{
              return(
                <div>
              <table>
                
                <td width="15%">{val.libraryName}</td>
                <td width="15%">{val.libraryAddress}</td>
                <td width="15%"><button key={val.libraryId} className="btn btn-primary" onClick={this.getBookDetails(val)}>Show Books</button></td>
              </table>
              </div>
              )
            })}
            </div>
        ):null}
        <br/>
        <br/>
        {this.state.books.length>0?(
          <div>
            <div>
              <b>Selected Library: {this.state.selectedLibrary}</b>
            </div>
            <div>
              <table>
                <tr>
                  <th width="15%">Book Name</th>
                  <th width="15%">Author</th>
                  <th width="15%">publisher</th>
                  <th width="15%">price</th>
                </tr>
              </table>
            </div>
            {this.state.books.map((val)=>{
              return(
                <div>
              <table>
                
                <td width="15%">{val.bookName}</td>
                <td width="15%">{val.author}</td>
                <td width="15%">{val.publisher}</td>
                <td width="15%">{val.price}</td>
              </table>
              </div>
              )
            })}
            </div>
        ):null}
      </div>
    );
  }
}

export default App;
