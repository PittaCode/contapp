import React from 'react';
import { useForm } from 'react-hook-form';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import InputGroup from 'react-bootstrap/InputGroup';
import isEmail from 'sane-email-validation';
import Subtitle from '../Headings/Subtitle';

import './Register.css';

function Register() {
  const { handleSubmit, register, errors, formState } = useForm({
    mode: 'onBlur',
  });
  const { touched, isValid } = formState;

  const onSubmit = (data, e) => {
    console.log('Submit event', e);
    alert(JSON.stringify(data));
  };

  const isEmailValid = (value) =>
    isEmail(value) || 'Provide a valid email address';

  return (
    <Form noValidate onSubmit={handleSubmit(onSubmit)}>
      <Form.Row>
        <Form.Group as={Col}>
          <Form.Group>
            <Subtitle text="Account Info" />
          </Form.Group>

          <Form.Group className="form-input-group" controlId="email">
            <Form.Control
              name="email"
              type="email"
              placeholder="Email"
              isValid={touched.email && !errors.email}
              isInvalid={!!errors.email}
              ref={register({
                required: 'An email address is needed',
                validate: isEmailValid,
              })}
            />
            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
            <Form.Control.Feedback type="invalid">
              {errors?.email?.message}
            </Form.Control.Feedback>
          </Form.Group>

          <Form.Group className="form-input-group" controlId="alias">
            <InputGroup>
              <InputGroup.Prepend>
                <InputGroup.Text id="inputGroupPrepend">@</InputGroup.Text>
              </InputGroup.Prepend>
              <Form.Control
                name="alias"
                type="text"
                placeholder="Alias"
                isValid={touched.alias && !errors.alias}
                isInvalid={!!errors.alias}
                ref={register({
                  required: 'An alias is required so people can identify you',
                  maxLength: {
                    value: 20,
                    message: 'The max length allowed is 20',
                  },
                })}
              />
              <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
              <Form.Control.Feedback type="invalid">
                {errors?.alias?.message}
              </Form.Control.Feedback>
            </InputGroup>
          </Form.Group>

          <Form.Group className="form-input-group" controlId="password">
            <Form.Control
              name="password"
              type="password"
              placeholder="Password"
              isValid={touched.password && !errors.password}
              isInvalid={!!errors.password}
              ref={register({
                required: 'A password is required',
                minLength: {
                  value: 16,
                  message: 'The min length allowed is 16',
                },
                maxLength: {
                  value: 40,
                  message: 'The max length allowed is 40',
                },
              })}
            />
            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
            <Form.Control.Feedback type="invalid">
              {errors?.password?.message}
            </Form.Control.Feedback>
          </Form.Group>
        </Form.Group>

        <Form.Group as={Col}>
          <Form.Group>
            <Subtitle text="Personal Info" />
          </Form.Group>

          <Form.Group className="form-input-group" controlId="name">
            <Form.Control
              name="name"
              type="text"
              placeholder="Name"
              isValid={touched.name && !errors.name}
              isInvalid={!!errors.name}
              ref={register({
                required: 'A name is required',
                minLength: {
                  value: 1,
                  message: 'The min length allowed is 1',
                },
                maxLength: {
                  value: 40,
                  message: 'The max length allowed is 40',
                },
                pattern: {
                  value: /^[A-z-]{1,40}$/,
                  message:
                    'The only characters allowed are: letters and hyphens',
                },
              })}
            />
            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
            <Form.Control.Feedback type="invalid">
              {errors?.name?.message}
            </Form.Control.Feedback>
          </Form.Group>

          <Form.Group className="form-input-group" controlId="middleName">
            <Form.Control
              name="middleName"
              type="text"
              placeholder="Middle Name(s)"
              isValid={touched.middleName && !errors.middleName}
              isInvalid={!!errors.middleName}
              ref={register({
                required: false,
                minLength: {
                  value: 1,
                  message: 'The min length allowed is 1',
                },
                maxLength: {
                  value: 40,
                  message: 'The max length allowed is 40',
                },
                pattern: {
                  value: /^[A-z .-]{1,40}$/,
                  message:
                    'The only characters allowed are: letters spaces, dots and hyphens',
                },
              })}
            />
            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
            <Form.Control.Feedback type="invalid">
              {errors?.middleName?.message}
            </Form.Control.Feedback>
          </Form.Group>

          <Form.Group className="form-input-group" controlId="familyName">
            <Form.Control
              name="familyName"
              type="text"
              placeholder="Family Name"
              isValid={touched.familyName && !errors.familyName}
              isInvalid={!!errors.familyName}
              ref={register({
                required: 'A family name is required',
                minLength: {
                  value: 1,
                  message: 'The min length allowed is 1',
                },
                maxLength: {
                  value: 40,
                  message: 'The max length allowed is 40',
                },
                pattern: {
                  value: /^[A-z-]{1,40}$/,
                  message:
                    'The only characters allowed are: letters and hyphens',
                },
              })}
            />
            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
            <Form.Control.Feedback type="invalid">
              {errors?.familyName?.message}
            </Form.Control.Feedback>
          </Form.Group>
        </Form.Group>
      </Form.Row>

      <Button variant="primary" size="lg" type="submit" disabled={!isValid}>
        Register
      </Button>
    </Form>
  );
}

export default Register;
