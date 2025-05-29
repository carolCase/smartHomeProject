import { render, screen, fireEvent } from "@testing-library/react"
import Sidebar from "../components/sidebars/Sidebar"

describe("Sidebar", () => {
  it("toggles collapsed state when button is clicked", () => {
    render(<Sidebar />)

    expect(screen.getByText("Smart Houses")).toBeInTheDocument()

    const toggleButton = screen.getByRole("button")
    fireEvent.click(toggleButton)

    expect(screen.getByText("SH")).toBeInTheDocument()
  })
})
