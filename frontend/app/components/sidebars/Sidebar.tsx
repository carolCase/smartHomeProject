"use client"

import { useState } from "react"
import { Button } from "../ui/button"
import { Home, Users, ChevronLeft, ChevronRight } from "lucide-react"
import Link from "next/link"
import React from "react"

export default function Sidebar() {
  const [collapsed, setCollapsed] = useState(false)
  const handleLogout = () => {
    document.cookie = "authToken=; Max-Age=0; path=/"

    window.location.href = "/login"
  }
  return (
    <div
      className={`${
        collapsed ? "w-16" : "w-48"
      } h-screen flex flex-col bg-white/30 backdrop-blur-md border-r border-white/30 text-white transition-all duration-300`}
    >
      {/* Scrollable content area */}
      <div className="flex-1 overflow-y-auto">
        <div className="flex items-center justify-between p-4">
          <span className="text-lg font-bold text-white">
            {collapsed ? "SH" : "Smart Houses"}
          </span>
          <Button
            className="ml-2 hover:bg-transparent"
            variant="ghost"
            size="icon"
            onClick={() => setCollapsed(!collapsed)}
          >
            {collapsed ? <ChevronRight size={18} /> : <ChevronLeft size={18} />}
          </Button>
        </div>

        <nav className="flex flex-col space-y-2 px-2">
          <Link
            href="/devices"
            className="flex items-center gap-3 p-2 rounded hover:bg-white/10"
          >
            <Home size={20} />
            {!collapsed && <span>Devices</span>}
          </Link>

          <Link
            href="/users"
            className="flex items-center gap-3 p-2 rounded hover:bg-white/10"
          >
            <Users size={20} />
            {!collapsed && <span>Manage Users</span>}
          </Link>
        </nav>

        <Button
          variant="ghost"
          className="w-full text-left px-4 py-2 text-white text-sm"
          onClick={handleLogout}
        >
          Logout
        </Button>
      </div>

      {/* Footer should not scroll */}
      <div className="px-4 py-3 text-xs text-white text-center border-t border-white/40">
        {collapsed ? (
          <span>SH</span>
        ) : (
          <>
            Smart Houses v1.0.0
            <br />© Castros Inc
          </>
        )}
      </div>
    </div>
  )
}
