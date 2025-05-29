import { render, screen, fireEvent } from "@testing-library/react"
import RegisterPage from "./page"
import React from "react"

jest.mock("next/navigation", () => ({
  useRouter: () => ({
    push: jest.fn(),
  }),
}))

describe("RegisterPage", () => {
  it("shows error message if email or password is missing", () => {
    render(<RegisterPage />)

    fireEvent.change(screen.getByPlaceholderText("Full Name (optional)"), {
      target: { value: "Test User" },
    })

    fireEvent.click(screen.getByText("Create Account"))

    expect(
      screen.getByText("Email and password are required.")
    ).toBeInTheDocument()
  })
})
