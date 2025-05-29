import { NextRequest, NextResponse } from "next/server"

export async function POST(req: NextRequest) {
  const body = await req.json()

  const response = await fetch("http://localhost:8080/register", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      email: body.email,
      password: body.password,
      fullName: body.fullName || "Smart Home User",
      registrationCode: body.registrationCode || null,
    }),
  })
  console.log("Sending to backend:", {
    email: body.email,
    password: body.password,
    fullName: body.fullName,
    registrationCode: body.registrationCode,
  })

  console.log("📥 Backend response:", response.status, response.headers)
  const text = await response.text()

  if (!response.ok) {
    return NextResponse.json({ error: text }, { status: response.status })
  }

  return NextResponse.json({ message: text })
}
