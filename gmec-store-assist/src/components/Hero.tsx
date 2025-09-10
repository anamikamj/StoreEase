import { Button } from "@/components/ui/button";
import { ArrowRight, Store, Users } from "lucide-react";
import heroImage from "@/assets/hero-image.jpg";

const Hero = () => {
  return (
    <section className="relative min-h-[80vh] flex items-center justify-center overflow-hidden">
      {/* Background with overlay */}
      <div className="absolute inset-0 bg-hero-gradient-light" />
      <div 
        className="absolute inset-0 opacity-10 bg-cover bg-center"
        style={{ backgroundImage: `url(${heroImage})` }}
      />
      
      <div className="relative z-10 container px-4 py-20">
        <div className="max-w-4xl mx-auto text-center">
          {/* College branding */}
          <div className="mb-8">
            <p className="text-sm font-medium text-primary-dark mb-2">
              GOVT. MODEL ENGINEERING COLLEGE, THRIKKAKARA
            </p>
            <p className="text-xs text-muted-foreground">
              Department of Computer Engineering • Academic Year 2025-2026
            </p>
          </div>

          {/* Main hero content */}
          <h1 className="text-4xl md:text-6xl font-bold text-foreground mb-6 leading-tight">
            <span className="bg-hero-gradient bg-clip-text text-transparent">
              StoreEase
            </span>
            <br />
            <span className="text-2xl md:text-4xl font-medium">
              Automated Inventory System
            </span>
          </h1>

          <p className="text-lg md:text-xl text-muted-foreground mb-8 max-w-2xl mx-auto leading-relaxed">
            Streamline your campus store operations with intelligent inventory management, 
            real-time stock tracking, and seamless online shopping for students and staff.
          </p>

          {/* CTA buttons */}
          <div className="flex flex-col sm:flex-row gap-4 justify-center items-center mb-12">
            <Button size="lg" className="bg-hero-gradient hover:opacity-90 shadow-elegant text-lg px-8 py-3">
              <Store className="h-5 w-5 mr-2" />
              Browse Store
              <ArrowRight className="h-5 w-5 ml-2" />
            </Button>
            <Button variant="outline" size="lg" className="text-primary border-primary hover:bg-primary/5 text-lg px-8 py-3">
              <Users className="h-5 w-5 mr-2" />
              Manager Dashboard
            </Button>
          </div>

          {/* Stats */}
          <div className="grid grid-cols-2 md:grid-cols-4 gap-6 max-w-2xl mx-auto">
            {[
              { label: "Items Tracked", value: "500+" },
              { label: "Students Served", value: "2000+" },
              { label: "Stock Accuracy", value: "99.9%" },
              { label: "Time Saved", value: "75%" }
            ].map((stat, index) => (
              <div key={index} className="text-center">
                <div className="text-2xl md:text-3xl font-bold text-primary mb-1">
                  {stat.value}
                </div>
                <div className="text-sm text-muted-foreground">
                  {stat.label}
                </div>
              </div>
            ))}
          </div>
        </div>
      </div>
    </section>
  );
};

export default Hero;