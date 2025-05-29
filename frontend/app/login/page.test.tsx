import React from "react"
import { render, screen, fireEvent } from "@testing-library/react"
import LoginPage from "./page"

jest.mock("next/navigation", () => ({
  useRouter: () => ({
    push: jest.fn(),
  }),
}))

describe("LoginPage", () => {
  it("shows error message if email or password is empty", async () => {
    render(<LoginPage />)

    const loginButton = screen.getByRole("button", { name: /login/i })
    fireEvent.click(loginButton)

    expect(
      await screen.findByText("Both fields are required.")
    ).toBeInTheDocument()
  })
})
