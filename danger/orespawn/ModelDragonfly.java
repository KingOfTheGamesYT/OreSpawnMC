/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelDragonfly
/*     */   extends ModelBase
/*     */ {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Shape1;
/*     */   
/*     */   ModelRenderer lfwing;
/*     */   ModelRenderer Shape3;
/*     */   ModelRenderer Shape4;
/*     */   ModelRenderer Shape5;
/*     */   ModelRenderer rjaw;
/*     */   ModelRenderer ljaw;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer tail2;
/*     */   ModelRenderer Shape10;
/*     */   ModelRenderer Shape11;
/*     */   ModelRenderer Shape12;
/*     */   ModelRenderer Shape13;
/*     */   ModelRenderer Shape14;
/*     */   ModelRenderer Shape15;
/*     */   ModelRenderer Shape16;
/*     */   ModelRenderer Shape17;
/*     */   ModelRenderer Shape18;
/*     */   ModelRenderer Shape19;
/*     */   ModelRenderer Shape20;
/*     */   ModelRenderer Shape21;
/*     */   ModelRenderer Shape22;
/*     */   ModelRenderer Shape23;
/*     */   ModelRenderer lrwing;
/*     */   ModelRenderer rfwing;
/*     */   ModelRenderer rrwing;
/*     */   
/*     */   public ModelDragonfly(float f1) {
/*  42 */     this.wingspeed = f1;
/*     */     
/*  44 */     this.textureWidth = 64;
/*  45 */     this.textureHeight = 64;
/*     */     
/*  47 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/*  48 */     this.Shape1.addBox(0.0F, 0.0F, 0.0F, 5, 4, 7);
/*  49 */     this.Shape1.setRotationPoint(0.0F, 16.0F, 0.0F);
/*  50 */     this.Shape1.setTextureSize(64, 64);
/*  51 */     this.Shape1.mirror = true;
/*  52 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*  53 */     this.lfwing = new ModelRenderer(this, 0, 33);
/*  54 */     this.lfwing.addBox(0.0F, 0.0F, 0.0F, 10, 1, 3);
/*  55 */     this.lfwing.setRotationPoint(5.0F, 16.0F, 1.0F);
/*  56 */     this.lfwing.setTextureSize(64, 64);
/*  57 */     this.lfwing.mirror = true;
/*  58 */     setRotation(this.lfwing, 0.0F, 0.4886922F, 0.0F);
/*  59 */     this.Shape3 = new ModelRenderer(this, 0, 13);
/*  60 */     this.Shape3.addBox(-2.0F, 0.0F, -4.0F, 4, 3, 4);
/*  61 */     this.Shape3.setRotationPoint(2.5F, 16.0F, -1.0F);
/*  62 */     this.Shape3.setTextureSize(64, 64);
/*  63 */     this.Shape3.mirror = true;
/*  64 */     setRotation(this.Shape3, 0.4886922F, 0.0F, 0.0F);
/*  65 */     this.Shape4 = new ModelRenderer(this, 9, 21);
/*  66 */     this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 3);
/*  67 */     this.Shape4.setRotationPoint(1.0F, 18.0F, -6.0F);
/*  68 */     this.Shape4.setTextureSize(64, 64);
/*  69 */     this.Shape4.mirror = true;
/*  70 */     setRotation(this.Shape4, 0.4886922F, 0.1745329F, 0.0F);
/*  71 */     this.Shape5 = new ModelRenderer(this, 0, 21);
/*  72 */     this.Shape5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 3);
/*  73 */     this.Shape5.setRotationPoint(3.0F, 18.0F, -6.0F);
/*  74 */     this.Shape5.setTextureSize(64, 64);
/*  75 */     this.Shape5.mirror = true;
/*  76 */     setRotation(this.Shape5, 0.4886922F, -0.1745329F, 0.0F);
/*  77 */     this.rjaw = new ModelRenderer(this, 0, 27);
/*  78 */     this.rjaw.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1);
/*  79 */     this.rjaw.setRotationPoint(2.0F, 19.0F, -5.0F);
/*  80 */     this.rjaw.setTextureSize(64, 64);
/*  81 */     this.rjaw.mirror = true;
/*  82 */     setRotation(this.rjaw, 0.4363323F, 0.1745329F, 0.0F);
/*  83 */     this.ljaw = new ModelRenderer(this, 5, 27);
/*  84 */     this.ljaw.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/*  85 */     this.ljaw.setRotationPoint(3.0F, 19.0F, -5.0F);
/*  86 */     this.ljaw.setTextureSize(64, 64);
/*  87 */     this.ljaw.mirror = true;
/*  88 */     setRotation(this.ljaw, 0.4363323F, -0.1745329F, 0.0F);
/*  89 */     this.tail1 = new ModelRenderer(this, 25, 0);
/*  90 */     this.tail1.addBox(-1.0F, 0.0F, 0.0F, 3, 3, 7);
/*  91 */     this.tail1.setRotationPoint(2.0F, 16.0F, 7.0F);
/*  92 */     this.tail1.setTextureSize(64, 64);
/*  93 */     this.tail1.mirror = true;
/*  94 */     setRotation(this.tail1, 0.0F, 0.0F, 0.0F);
/*  95 */     this.tail2 = new ModelRenderer(this, 25, 11);
/*  96 */     this.tail2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 9);
/*  97 */     this.tail2.setRotationPoint(2.0F, 16.0F, 14.0F);
/*  98 */     this.tail2.setTextureSize(64, 64);
/*  99 */     this.tail2.mirror = true;
/* 100 */     setRotation(this.tail2, 0.0F, 0.0F, 0.0F);
/* 101 */     this.Shape10 = new ModelRenderer(this, 23, 0);
/* 102 */     this.Shape10.addBox(-1.0F, 0.0F, 0.0F, 1, 4, 1);
/* 103 */     this.Shape10.setRotationPoint(1.0F, 18.0F, 0.0F);
/* 104 */     this.Shape10.setTextureSize(64, 64);
/* 105 */     this.Shape10.mirror = true;
/* 106 */     setRotation(this.Shape10, -0.2792527F, 0.0F, 0.3490659F);
/* 107 */     this.Shape11 = new ModelRenderer(this, 40, 0);
/* 108 */     this.Shape11.addBox(0.0F, 0.0F, -4.0F, 1, 1, 4);
/* 109 */     this.Shape11.setRotationPoint(-1.0F, 21.0F, 0.0F);
/* 110 */     this.Shape11.setTextureSize(64, 64);
/* 111 */     this.Shape11.mirror = true;
/* 112 */     setRotation(this.Shape11, 0.0F, 0.0F, 0.0F);
/* 113 */     this.Shape12 = new ModelRenderer(this, 18, 12);
/* 114 */     this.Shape12.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1);
/* 115 */     this.Shape12.setRotationPoint(0.0F, 21.0F, -4.0F);
/* 116 */     this.Shape12.setTextureSize(64, 64);
/* 117 */     this.Shape12.mirror = true;
/* 118 */     setRotation(this.Shape12, 0.0F, 0.0F, -0.1919862F);
/* 119 */     this.Shape13 = new ModelRenderer(this, 18, 0);
/* 120 */     this.Shape13.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
/* 121 */     this.Shape13.setRotationPoint(4.0F, 18.0F, 0.0F);
/* 122 */     this.Shape13.setTextureSize(64, 64);
/* 123 */     this.Shape13.mirror = true;
/* 124 */     setRotation(this.Shape13, -0.2792527F, 0.0F, -0.3490659F);
/* 125 */     this.Shape14 = new ModelRenderer(this, 51, 0);
/* 126 */     this.Shape14.addBox(0.0F, 0.0F, -4.0F, 1, 1, 4);
/* 127 */     this.Shape14.setRotationPoint(5.0F, 21.0F, 0.0F);
/* 128 */     this.Shape14.setTextureSize(64, 64);
/* 129 */     this.Shape14.mirror = true;
/* 130 */     setRotation(this.Shape14, 0.0F, 0.0F, 0.0F);
/* 131 */     this.Shape15 = new ModelRenderer(this, 13, 12);
/* 132 */     this.Shape15.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/* 133 */     this.Shape15.setRotationPoint(5.0F, 21.0F, -4.0F);
/* 134 */     this.Shape15.setTextureSize(64, 64);
/* 135 */     this.Shape15.mirror = true;
/* 136 */     setRotation(this.Shape15, 0.0F, 0.0F, 0.1919862F);
/* 137 */     this.Shape16 = new ModelRenderer(this, 9, 53);
/* 138 */     this.Shape16.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
/* 139 */     this.Shape16.setRotationPoint(5.0F, 19.5F, 3.0F);
/* 140 */     this.Shape16.setTextureSize(64, 64);
/* 141 */     this.Shape16.mirror = true;
/* 142 */     setRotation(this.Shape16, 0.0F, 0.0F, 0.6457718F);
/* 143 */     this.Shape17 = new ModelRenderer(this, 0, 56);
/* 144 */     this.Shape17.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/* 145 */     this.Shape17.setRotationPoint(6.0F, 21.0F, 3.0F);
/* 146 */     this.Shape17.setTextureSize(64, 64);
/* 147 */     this.Shape17.mirror = true;
/* 148 */     setRotation(this.Shape17, 0.0F, 0.0F, 0.0F);
/* 149 */     this.Shape18 = new ModelRenderer(this, 0, 53);
/* 150 */     this.Shape18.addBox(-3.0F, 0.0F, 0.0F, 3, 1, 1);
/* 151 */     this.Shape18.setRotationPoint(0.0F, 19.5F, 3.0F);
/* 152 */     this.Shape18.setTextureSize(64, 64);
/* 153 */     this.Shape18.mirror = true;
/* 154 */     setRotation(this.Shape18, 0.0F, 0.0F, -0.6457718F);
/* 155 */     this.Shape19 = new ModelRenderer(this, 5, 56);
/* 156 */     this.Shape19.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1);
/* 157 */     this.Shape19.setRotationPoint(-1.0F, 21.0F, 3.0F);
/* 158 */     this.Shape19.setTextureSize(64, 64);
/* 159 */     this.Shape19.mirror = true;
/* 160 */     setRotation(this.Shape19, 0.0F, 0.0F, 0.0F);
/* 161 */     this.Shape20 = new ModelRenderer(this, 9, 61);
/* 162 */     this.Shape20.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
/* 163 */     this.Shape20.setRotationPoint(4.0F, 19.5F, 6.0F);
/* 164 */     this.Shape20.setTextureSize(64, 64);
/* 165 */     this.Shape20.mirror = true;
/* 166 */     setRotation(this.Shape20, 0.0F, -0.6457718F, 0.5061455F);
/* 167 */     this.Shape21 = new ModelRenderer(this, 0, 61);
/* 168 */     this.Shape21.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
/* 169 */     this.Shape21.setRotationPoint(1.5F, 19.5F, 7.0F);
/* 170 */     this.Shape21.setTextureSize(64, 64);
/* 171 */     this.Shape21.mirror = true;
/* 172 */     setRotation(this.Shape21, 0.0F, -2.391101F, 0.5061455F);
/* 173 */     this.Shape22 = new ModelRenderer(this, 0, 0);
/* 174 */     this.Shape22.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/* 175 */     this.Shape22.setRotationPoint(-1.0F, 21.0F, 7.5F);
/* 176 */     this.Shape22.setTextureSize(64, 64);
/* 177 */     this.Shape22.mirror = true;
/* 178 */     setRotation(this.Shape22, 0.0F, 0.0F, 0.0F);
/* 179 */     this.Shape23 = new ModelRenderer(this, 0, 13);
/* 180 */     this.Shape23.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/* 181 */     this.Shape23.setRotationPoint(5.0F, 21.0F, 7.5F);
/* 182 */     this.Shape23.setTextureSize(64, 64);
/* 183 */     this.Shape23.mirror = true;
/* 184 */     setRotation(this.Shape23, 0.0F, 0.0F, 0.0F);
/* 185 */     this.lrwing = new ModelRenderer(this, 0, 38);
/* 186 */     this.lrwing.addBox(0.0F, 0.0F, -3.0F, 10, 1, 3);
/* 187 */     this.lrwing.setRotationPoint(5.0F, 16.0F, 6.0F);
/* 188 */     this.lrwing.setTextureSize(64, 64);
/* 189 */     this.lrwing.mirror = true;
/* 190 */     setRotation(this.lrwing, 0.0F, -0.3839724F, 0.0F);
/* 191 */     this.rfwing = new ModelRenderer(this, 0, 48);
/* 192 */     this.rfwing.addBox(-10.0F, 0.0F, 0.0F, 10, 1, 3);
/* 193 */     this.rfwing.setRotationPoint(0.0F, 16.0F, 1.0F);
/* 194 */     this.rfwing.setTextureSize(64, 64);
/* 195 */     this.rfwing.mirror = true;
/* 196 */     setRotation(this.rfwing, 0.0F, -0.4886922F, 0.0F);
/* 197 */     this.rrwing = new ModelRenderer(this, 0, 43);
/* 198 */     this.rrwing.addBox(-10.0F, 0.0F, -3.0F, 10, 1, 3);
/* 199 */     this.rrwing.setRotationPoint(0.0F, 16.0F, 6.0F);
/* 200 */     this.rrwing.setTextureSize(64, 64);
/* 201 */     this.rrwing.mirror = true;
/* 202 */     setRotation(this.rrwing, 0.0F, 0.3839724F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 207 */     float newangle = 0.0F;
/* 208 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 209 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 212 */     newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F;
/* 213 */     this.lfwing.rotateAngleZ = newangle;
/* 214 */     this.rfwing.rotateAngleZ = -newangle;
/* 215 */     this.lrwing.rotateAngleZ = newangle + 3.14F;
/* 216 */     this.rrwing.rotateAngleZ = -newangle + 3.14F;
/*     */     
/* 218 */     newangle = MathHelper.cos(f2 * 0.3F * this.wingspeed) * 3.1415927F * 0.1F;
/* 219 */     this.ljaw.rotateAngleX = newangle;
/* 220 */     this.rjaw.rotateAngleX = -newangle;
/*     */     
/* 222 */     this.Shape1.render(f5);
/* 223 */     this.lfwing.render(f5);
/* 224 */     this.Shape3.render(f5);
/* 225 */     this.Shape4.render(f5);
/* 226 */     this.Shape5.render(f5);
/* 227 */     this.rjaw.render(f5);
/* 228 */     this.ljaw.render(f5);
/* 229 */     this.tail1.render(f5);
/* 230 */     this.tail2.render(f5);
/* 231 */     this.Shape10.render(f5);
/* 232 */     this.Shape11.render(f5);
/* 233 */     this.Shape12.render(f5);
/* 234 */     this.Shape13.render(f5);
/* 235 */     this.Shape14.render(f5);
/* 236 */     this.Shape15.render(f5);
/* 237 */     this.Shape16.render(f5);
/* 238 */     this.Shape17.render(f5);
/* 239 */     this.Shape18.render(f5);
/* 240 */     this.Shape19.render(f5);
/* 241 */     this.Shape20.render(f5);
/* 242 */     this.Shape21.render(f5);
/* 243 */     this.Shape22.render(f5);
/* 244 */     this.Shape23.render(f5);
/* 245 */     this.lrwing.render(f5);
/* 246 */     this.rfwing.render(f5);
/* 247 */     this.rrwing.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 254 */     model.rotateAngleX = x;
/* 255 */     model.rotateAngleY = y;
/* 256 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 261 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelDragonfly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */