import React from 'react';
import './file-upload-box.styles.css'
import CustomButton from '../custom-button/custom-button.component'
import CustomInput from '../custom-button/custom-input.component'
import Card from 'react-bootstrap/Card';
import axios from "axios";
class FileUploadBox extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: '',
            selectedFile: null
        }
    }
    onFileChange = event => {

        this.setState({selectedFile: event.target.files[0]});

    };

    onFileUpload = () => {

        const formData = new FormData();

        formData.append(
            "myFile",
            this.state.selectedFile,
            this.state.selectedFile.name
        );

        console.log(this.state.selectedFile);

        axios.post("api/uploadfile", formData);
    };

    fileData = () => {

        if (this.state.selectedFile) {

            return (

                <div>
                    <Card bg = 'dark' style={{ width: '18rem' }}>
                        {/*<Card.Img variant="top" src="holder.js/100px180" />*/}
                        <Card.Body>
                            <Card.Title><h2>File Details:</h2></Card.Title>
                            <Card.Text>
                                <p>File Name: {this.state.selectedFile.name}</p>
                                <p>File Type: {this.state.selectedFile.type}</p>
                                <p>
                                    Last Modified:{" "}
                                    {this.state.selectedFile.lastModifiedDate.toDateString()}
                                </p>
                            </Card.Text>
                        </Card.Body>
                    </Card>

                </div>
            );
        } else {
            return (
                <div>
                    <br/>
                    <h4>Choose before Pressing the Upload button</h4>

                </div>
            );
        }
    };


    handleSubmit = event => {
        event.preventDefault();
        this.setState({email: '', password: ''});
    };

    handleChange = event => {
        const {value, name} = event.target;
        this.setState({[name]: value});
    }

    render() {
        return (
            <div className="sign-in">
                <div>
                    <CustomInput type="file" onChange={this.onFileChange}/>

                    <CustomButton onClick={this.onFileUpload}>
                        Upload!
                    </CustomButton>
                </div>

                {this.fileData()}

            </div>

        )
    }
}

export default FileUploadBox;
