import React from 'react';
import { useForm } from 'react-hook-form';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Subtitle from '../Headings/Subtitle';

function Register() {
  const { handleSubmit, register } = useForm({
    mode: 'onBlur',
    validateCriteriaMode: 'all',
  });
  const onSubmit = (data, e) => {
    console.log('Submit event', e);
    alert(JSON.stringify(data));
  };

  return (
    <Form onSubmit={handleSubmit(onSubmit)}>
      <Form.Row>
        <Form.Group as={Col}>
          <Form.Group>
            <Subtitle text="Account Info" />
          </Form.Group>

          <Form.Group controlId="email">
            <Form.Control
              name="email"
              type="email"
              placeholder="Enter email"
              ref={register}
            />
          </Form.Group>

          <Form.Group controlId="alias">
            <Form.Control name="alias" placeholder="Alias" ref={register} />
          </Form.Group>

          <Form.Group controlId="password">
            <Form.Control
              name="password"
              type="password"
              placeholder="Password"
              ref={register}
            />
          </Form.Group>
        </Form.Group>

        <Form.Group as={Col}>
          <Form.Group>
            <Subtitle text="Personal Info" />
          </Form.Group>

          <Form.Group controlId="name">
            <Form.Control name="name" placeholder="Name" ref={register} />
          </Form.Group>

          <Form.Group controlId="middle-name">
            <Form.Control
              name="middle-name"
              placeholder="Middle Name(s)"
              ref={register}
            />
          </Form.Group>

          <Form.Group controlId="family-name">
            <Form.Control
              name="family-name"
              placeholder="Family Name"
              ref={register}
            />
          </Form.Group>
        </Form.Group>
      </Form.Row>

      <Button variant="primary" type="submit">
        Register
      </Button>
    </Form>
  );
}

export default Register;
