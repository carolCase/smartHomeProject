import { render, screen, fireEvent } from "@testing-library/react"
import Sidebar from "./Sidebar"
import React from "react"

describe("Sidebar", () => {
  it("toggles collapsed state when button is clicked", () => {
    render(<Sidebar />)

    expect(screen.getByText("Smart Houses")).toBeInTheDocument()

    const toggleButton = screen.getAllByRole("button")[0]
    fireEvent.click(toggleButton)

    expect(screen.getAllByText("SH").length).toBeGreaterThan(0)
  })
})
