import { Separator } from "@/components/ui/separator";
import { Mail, Phone, MapPin, ExternalLink } from "lucide-react";

const Footer = () => {
  return (
    <footer className="bg-foreground text-background py-12">
      <div className="container px-4">
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-8">
          {/* College Info */}
          <div className="space-y-4">
            <div>
              <h3 className="font-bold text-lg mb-2">StoreEase</h3>
              <p className="text-sm text-background/80 leading-relaxed">
                Automated Inventory System for Campus Supply Stores
              </p>
            </div>
            <div className="text-xs text-background/70">
              <p className="font-medium">GOVT. MODEL ENGINEERING COLLEGE</p>
              <p>THRIKKAKARA</p>
              <p className="mt-1">Managed by IHRD, Govt. of Kerala</p>
            </div>
          </div>

          {/* Department Info */}
          <div className="space-y-4">
            <h4 className="font-semibold text-sm">Department</h4>
            <div className="text-xs text-background/80 space-y-2">
              <p>Department of Computer Engineering</p>
              <p>Academic Year 2025-2026</p>
              <p>Mini Project - PBCST304</p>
              <p className="italic">"Evolve into a centre of excellence to serve the emerging knowledge society"</p>
            </div>
          </div>

          {/* Quick Links */}
          <div className="space-y-4">
            <h4 className="font-semibold text-sm">Quick Links</h4>
            <div className="space-y-2 text-xs">
              <a href="#" className="block text-background/80 hover:text-background transition-colors">
                Student Login
              </a>
              <a href="#" className="block text-background/80 hover:text-background transition-colors">
                Manager Dashboard
              </a>
              <a href="#" className="block text-background/80 hover:text-background transition-colors">
                Browse Categories
              </a>
              <a href="#" className="block text-background/80 hover:text-background transition-colors">
                Track Orders
              </a>
              <a href="#" className="block text-background/80 hover:text-background transition-colors">
                Help & Support
              </a>
            </div>
          </div>

          {/* Contact Info */}
          <div className="space-y-4">
            <h4 className="font-semibold text-sm">Project Guide</h4>
            <div className="text-xs text-background/80 space-y-2">
              <p className="font-medium">Ms. Chinju P Varghese</p>
              <p>Assistant Professor</p>
              <p>Department of Computer Engineering</p>
            </div>
            <div className="space-y-2 text-xs">
              <div className="flex items-center space-x-2">
                <Mail className="h-3 w-3" />
                <span className="text-background/80">store@gmec.ac.in</span>
              </div>
              <div className="flex items-center space-x-2">
                <MapPin className="h-3 w-3" />
                <span className="text-background/80">GMEC Campus, Thrikkakara</span>
              </div>
            </div>
          </div>
        </div>

        <Separator className="my-8 bg-background/20" />

        <div className="flex flex-col md:flex-row justify-between items-center space-y-4 md:space-y-0">
          <div className="text-xs text-background/70">
            <p>&copy; 2025 StoreEase - GMEC Computer Engineering Department. All rights reserved.</p>
          </div>
          <div className="flex items-center space-x-4 text-xs text-background/70">
            <span>Powered by Modern Web Technologies</span>
            <div className="flex items-center space-x-1">
              <span>React</span>
              <span>•</span>
              <span>TypeScript</span>
              <span>•</span>
              <span>Tailwind CSS</span>
            </div>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;