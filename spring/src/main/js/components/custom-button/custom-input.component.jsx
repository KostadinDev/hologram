import React from 'react';

//import './custom-input.css';

const CustomInput = ({children, ...otherProps}) => (
    <input className='custom-input' {...otherProps}>
        {children}
    </input>
);

export default CustomInput;
