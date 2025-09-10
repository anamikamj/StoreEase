import { Button } from "@/components/ui/button";
import { ShoppingCart, User, Menu } from "lucide-react";
import { Link } from "react-router-dom";

const Header = () => {
  return (
    <header className="sticky top-0 z-50 w-full border-b bg-background/95 backdrop-blur supports-[backdrop-filter]:bg-background/60">
      <div className="container flex h-16 items-center justify-between px-4">
        <div className="flex items-center space-x-4">
          <Link to="/" className="flex items-center space-x-2">
            <div className="h-8 w-8 rounded-lg bg-hero-gradient flex items-center justify-center">
              <span className="text-white font-bold text-sm">SE</span>
            </div>
            <div>
              <h1 className="text-xl font-bold text-primary">StoreEase</h1>
              <p className="text-xs text-muted-foreground">GMEC Campus Store</p>
            </div>
          </Link>
        </div>

        <nav className="hidden md:flex items-center space-x-6">
          <Link to="/store" className="text-sm font-medium text-foreground hover:text-primary transition-colors">
            Store
          </Link>
          <Link to="/categories" className="text-sm font-medium text-foreground hover:text-primary transition-colors">
            Categories
          </Link>
          <Link to="/orders" className="text-sm font-medium text-foreground hover:text-primary transition-colors">
            Orders
          </Link>
          <Link to="/notifications" className="text-sm font-medium text-foreground hover:text-primary transition-colors">
            Notifications
          </Link>
        </nav>

        <div className="flex items-center space-x-3">
          <Link to="/login">
            <Button variant="ghost" size="sm" className="hidden md:flex">
              <User className="h-4 w-4 mr-2" />
              Login
            </Button>
          </Link>
          <Link to="/store">
            <Button size="sm" className="bg-hero-gradient hover:opacity-90">
              Browse Store
            </Button>
          </Link>
          <Button variant="ghost" size="sm" className="md:hidden">
            <Menu className="h-4 w-4" />
          </Button>
        </div>
      </div>
    </header>
  );
};

export default Header;