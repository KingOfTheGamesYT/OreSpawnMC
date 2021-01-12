/*      */ package danger.orespawn;
/*      */ 
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.ai.EntityAILookIdle;
/*      */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.network.Packet;
/*      */ import net.minecraft.network.play.client.C03PacketPlayer;
/*      */ import net.minecraft.network.play.client.C0CPacketInput;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.world.EnumDifficulty;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SpiderRobot
/*      */   extends EntityLiving
/*      */ {
/*      */   private int boatPosRotationIncrements;
/*      */   private double boatX;
/*      */   private double boatY;
/*      */   private double boatZ;
/*      */   private double boatYaw;
/*      */   private double boatPitch;
/*   67 */   private int playing = 0;
/*      */ 
/*      */   
/*   70 */   private GenericTargetSorter TargetSorter = null;
/*   71 */   private float moveSpeed = 0.35F;
/*   72 */   private RenderSpiderRobotInfo renderdata = new RenderSpiderRobotInfo();
/*   73 */   private int didonce = 0;
/*   74 */   private int rideTicker = 0;
/*      */ 
/*      */   
/*      */   public SpiderRobot(World par1World) {
/*   78 */     super(par1World);
/*   79 */     setSize(3.25F, 2.25F);
/*   80 */     this.riddenByEntity = null;
/*   81 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*   82 */     this.tasks.addTask(0, (EntityAIBase)new EntityAIWatchClosest(this, EntityPlayer.class, 12.0F));
/*   83 */     this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle(this));
/*   84 */     this.isImmuneToFire = true;
/*   85 */     this.experienceValue = OreSpawnMain.SpiderRobot_stats.health / 2;
/*      */   }
/*      */ 
/*      */   
/*      */   public SpiderRobot(World par1World, double par2, double par4, double par6) {
/*   90 */     this(par1World);
/*   91 */     setPosition(par2, par4 + this.yOffset, par6);
/*   92 */     this.motionX = 0.0D;
/*   93 */     this.motionY = 0.0D;
/*   94 */     this.motionZ = 0.0D;
/*   95 */     this.prevPosX = par2;
/*   96 */     this.prevPosY = par4;
/*   97 */     this.prevPosZ = par6;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void applyEntityAttributes() {
/*  102 */     super.applyEntityAttributes();
/*  103 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(OreSpawnMain.SpiderRobot_stats.health);
/*  104 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  105 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  106 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.SpiderRobot_stats.attack);
/*      */   }
/*      */   
/*      */   protected boolean canDespawn() {
/*  110 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTotalArmorValue() {
/*  118 */     return OreSpawnMain.SpiderRobot_stats.defense;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void updateAITasks() {
/*  123 */     if (this.isDead)
/*  124 */       return;  if (this.riddenByEntity != null)
/*  125 */       return;  super.updateAITasks();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateAITick() {
/*  134 */     if (this.riddenByEntity != null)
/*  135 */       return;  super.updateAITick();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void initLegData() {
/*  141 */     if (this.renderdata == null) {
/*  142 */       this.renderdata = new RenderSpiderRobotInfo();
/*      */     }
/*  144 */     for (int i = 0; i < 8; i++) {
/*  145 */       this.renderdata.ycurrentangle[i] = 0.0F;
/*  146 */       this.renderdata.ywantedangle[i] = 0.0F;
/*  147 */       this.renderdata.ydisplayangle[i] = 0.0F;
/*  148 */       this.renderdata.yvelocity[i] = 0.0F;
/*  149 */       this.renderdata.ymid[i] = 0.0F;
/*  150 */       this.renderdata.yoff[i] = 0.0F;
/*  151 */       this.renderdata.yrange[i] = 0.0F;
/*  152 */       this.renderdata.udcurrentangle[i] = 0.0F;
/*  153 */       this.renderdata.udwantedangle[i] = 0.0F;
/*  154 */       this.renderdata.uddisplayangle[i] = 0.0F;
/*  155 */       this.renderdata.udvelocity[i] = 0.0F;
/*  156 */       this.renderdata.p1xangle[i] = 0.7853981633974483D;
/*  157 */       this.renderdata.p2xangle[i] = 0.0D;
/*  158 */       this.renderdata.p3xangle[i] = -0.7853981633974483D;
/*  159 */       this.renderdata.pxvelocity[i] = 0.0F;
/*  160 */       this.renderdata.foot_xpos[i] = (float)this.posX;
/*  161 */       this.renderdata.foot_ypos[i] = (float)this.posY;
/*  162 */       this.renderdata.foot_zpos[i] = (float)this.posZ;
/*  163 */       this.renderdata.realposx[i] = 0.0F;
/*  164 */       this.renderdata.realposy[i] = 0.0F;
/*  165 */       this.renderdata.realposz[i] = 0.0F;
/*  166 */       this.renderdata.legoff[i] = 0.0F;
/*  167 */       this.renderdata.footup[i] = 1;
/*  168 */       this.renderdata.uppoint[i] = 0.0F;
/*  169 */       this.renderdata.footingticker[i] = 0;
/*  170 */       this.renderdata.gpcounter = 0;
/*  171 */       if (i == 0) {
/*  172 */         this.renderdata.legoff[i] = 1.25F;
/*  173 */         this.renderdata.ymid[i] = -0.32F;
/*  174 */         this.renderdata.yrange[i] = 0.2617994F;
/*  175 */         this.renderdata.pairedwith[i] = 1;
/*  176 */         this.renderdata.yoff[i] = -0.3F;
/*      */       } 
/*  178 */       if (i == 1) {
/*  179 */         this.renderdata.legoff[i] = 1.25F;
/*  180 */         this.renderdata.ymid[i] = 3.4615927F;
/*  181 */         this.renderdata.yrange[i] = -0.2617994F;
/*  182 */         this.renderdata.pairedwith[i] = 0;
/*  183 */         this.renderdata.yoff[i] = -0.3F;
/*      */       } 
/*  185 */       if (i == 2) {
/*  186 */         this.renderdata.legoff[i] = 2.0F;
/*  187 */         this.renderdata.ymid[i] = -1.0F;
/*  188 */         this.renderdata.yrange[i] = 0.2617994F;
/*  189 */         this.renderdata.pairedwith[i] = 3;
/*  190 */         this.renderdata.yoff[i] = -0.1F;
/*      */       } 
/*  192 */       if (i == 3) {
/*  193 */         this.renderdata.legoff[i] = 2.0F;
/*  194 */         this.renderdata.ymid[i] = 4.1415925F;
/*  195 */         this.renderdata.yrange[i] = -0.2617994F;
/*  196 */         this.renderdata.pairedwith[i] = 2;
/*  197 */         this.renderdata.yoff[i] = -0.1F;
/*      */       } 
/*      */       
/*  200 */       if (i == 4) {
/*  201 */         this.renderdata.legoff[i] = 1.75F;
/*  202 */         this.renderdata.ymid[i] = 0.62831855F;
/*  203 */         this.renderdata.yrange[i] = 0.2617994F;
/*  204 */         this.renderdata.pairedwith[i] = 5;
/*  205 */         this.renderdata.yoff[i] = -0.3F;
/*      */       } 
/*  207 */       if (i == 5) {
/*  208 */         this.renderdata.legoff[i] = 1.75F;
/*  209 */         this.renderdata.ymid[i] = 2.5132742F;
/*  210 */         this.renderdata.yrange[i] = -0.2617994F;
/*  211 */         this.renderdata.pairedwith[i] = 4;
/*  212 */         this.renderdata.yoff[i] = -0.3F;
/*      */       } 
/*  214 */       if (i == 6) {
/*  215 */         this.renderdata.legoff[i] = 3.4F;
/*  216 */         this.renderdata.ymid[i] = 1.05F;
/*  217 */         this.renderdata.yrange[i] = 0.2617994F;
/*  218 */         this.renderdata.pairedwith[i] = 7;
/*  219 */         this.renderdata.yoff[i] = -0.1F;
/*      */       } 
/*  221 */       if (i == 7) {
/*  222 */         this.renderdata.legoff[i] = 3.4F;
/*  223 */         this.renderdata.ymid[i] = 2.0915928F;
/*  224 */         this.renderdata.yrange[i] = -0.2617994F;
/*  225 */         this.renderdata.pairedwith[i] = 6;
/*  226 */         this.renderdata.yoff[i] = -0.1F;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private float getNewVelocity(float v, float diff, float curval) {
/*  234 */     float tv = v;
/*      */     
/*  236 */     tv *= 8.0F;
/*  237 */     if (tv < 1.0F) tv = 1.0F; 
/*  238 */     if (tv > 4.0F) tv = 4.0F;
/*      */     
/*  240 */     if (diff > 0.0F) {
/*  241 */       if (diff < 0.008726646259971648D * tv) {
/*  242 */         curval = 0.0F;
/*      */       } else {
/*  244 */         curval = (float)(curval + 0.004363323129985824D * tv);
/*  245 */         if (diff < 0.06981317007977318D * tv) curval = (float)(0.017453292519943295D * tv); 
/*  246 */         if (diff < 0.03490658503988659D * tv) curval = (float)(0.008726646259971648D * tv); 
/*  247 */         if (curval > 0.06981317007977318D * tv) curval = (float)(0.06981317007977318D * tv);
/*      */       
/*      */       } 
/*  250 */     } else if (diff > -0.008726646259971648D * tv) {
/*  251 */       curval = 0.0F;
/*      */     } else {
/*  253 */       curval = (float)(curval - 0.004363323129985824D * tv);
/*  254 */       if (diff > -0.06981317007977318D * tv) curval = -((float)(0.017453292519943295D * tv)); 
/*  255 */       if (diff > -0.03490658503988659D * tv) curval = -((float)(0.008726646259971648D * tv)); 
/*  256 */       if (curval < -0.06981317007977318D * tv) curval = -((float)(0.06981317007977318D * tv));
/*      */     
/*      */     } 
/*  259 */     return curval;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateLegs() {
/*  274 */     if (!this.worldObj.isRemote)
/*  275 */       return;  this.rotationYaw %= 360.0F;
/*  276 */     for (; this.rotationYaw < 0.0F; this.rotationYaw += 360.0F);
/*  277 */     this.renderdata.gpcounter++;
/*      */     
/*  279 */     if (this.didonce == 0) {
/*  280 */       this.didonce = 1;
/*  281 */       initLegData();
/*      */     } 
/*      */ 
/*      */     
/*  285 */     float d1 = (float)(this.prevPosX - this.posX);
/*  286 */     float d2 = (float)(this.prevPosY - this.posY);
/*  287 */     float d3 = (float)(this.prevPosZ - this.posZ);
/*  288 */     float realv = (float)Math.sqrt((d1 * d1 + d2 * d2 + d3 * d3));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  293 */     int i = 0;
/*      */     
/*  295 */     for (i = 0; i < 8; i++) {
/*  296 */       int fcount = 0;
/*  297 */       this.renderdata.footingticker[i] = this.renderdata.footingticker[i] + 1;
/*      */       
/*  299 */       this.renderdata.realposx[i] = (float)(this.posX - this.renderdata.legoff[i] * Math.sin(Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0F))) + this.renderdata.ymid[i]));
/*  300 */       this.renderdata.realposz[i] = (float)(this.posZ + this.renderdata.legoff[i] * Math.cos(Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0F))) + this.renderdata.ymid[i]));
/*  301 */       this.renderdata.realposy[i] = (float)this.posY + this.renderdata.yoff[i];
/*      */       
/*  303 */       int it = this.renderdata.footingticker[i] + this.renderdata.footingticker[this.renderdata.pairedwith[i]];
/*  304 */       if (it > 50 && this.renderdata.footingticker[i] > this.renderdata.footingticker[this.renderdata.pairedwith[i]]) {
/*  305 */         this.renderdata.footingticker[i] = 0;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  310 */       d1 = this.renderdata.realposx[i] - this.renderdata.foot_xpos[i];
/*  311 */       d2 = this.renderdata.realposy[i] - this.renderdata.foot_ypos[i];
/*  312 */       d3 = this.renderdata.realposz[i] - this.renderdata.foot_zpos[i];
/*  313 */       float dd = (float)Math.sqrt((d1 * d1 + d2 * d2 + d3 * d3));
/*  314 */       dd *= 16.0F;
/*      */       
/*  316 */       float da = (float)(Math.abs(this.renderdata.ycurrentangle[i] - Math.toRadians(MathHelper.wrapAngleTo180_double(this.rotationYaw)) + this.renderdata.ymid[i]) % 6.283185307179586D);
/*  317 */       if (da > Math.PI) da = (float)(da - 6.283185307179586D); 
/*  318 */       if (da < -3.141592653589793D) da = (float)(da + 6.283185307179586D); 
/*  319 */       da = Math.abs(da);
/*      */ 
/*      */       
/*  322 */       if (dd > 294.0F || dd < 32.0F || da > Math.abs(this.renderdata.yrange[i]) * 8.0F / 7.0F || Math.abs(this.renderdata.udcurrentangle[i]) > 1.25D || this.renderdata.footingticker[i] == 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  329 */         findNewFooting(i);
/*  330 */         d1 = this.renderdata.realposx[i] - this.renderdata.foot_xpos[i];
/*  331 */         d2 = this.renderdata.realposy[i] - this.renderdata.foot_ypos[i];
/*  332 */         d3 = this.renderdata.realposz[i] - this.renderdata.foot_zpos[i];
/*  333 */         dd = (float)Math.sqrt((d1 * d1 + d2 * d2 + d3 * d3));
/*  334 */         dd *= 16.0F;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  341 */       float c1 = (float)(99.0D * Math.cos(this.renderdata.p2xangle[i] - this.renderdata.p1xangle[i]));
/*  342 */       float c2 = 99.0F;
/*  343 */       float c3 = (float)(99.0D * Math.cos(this.renderdata.p2xangle[i] - this.renderdata.p3xangle[i]));
/*  344 */       float cc = c1 + c2 + c3;
/*      */       
/*  346 */       float diff = cc - dd;
/*  347 */       this.renderdata.pxvelocity[i] = getNewVelocity(realv, (float)(diff * Math.PI / 360.0D), this.renderdata.pxvelocity[i]);
/*  348 */       if (this.renderdata.pxvelocity[i] == 0.0F || Math.abs(diff) < 8.0F) fcount++; 
/*  349 */       this.renderdata.p1xangle[i] = this.renderdata.p1xangle[i] + this.renderdata.pxvelocity[i];
/*  350 */       this.renderdata.p2xangle[i] = 0.0D;
/*  351 */       this.renderdata.p3xangle[i] = -this.renderdata.p1xangle[i];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  361 */       if (this.renderdata.uppoint[i] != 0.0F) {
/*  362 */         dd = (float)Math.atan2(dd, (this.renderdata.realposy[i] - this.renderdata.uppoint[i]) * 16.0D);
/*      */       } else {
/*  364 */         dd = (float)Math.atan2(dd, (this.renderdata.realposy[i] - this.renderdata.foot_ypos[i]) * 16.0D);
/*      */       } 
/*  366 */       this.renderdata.udwantedangle[i] = (float)(dd - 1.5707963267948966D);
/*  367 */       for (; this.renderdata.udwantedangle[i] > Math.PI; this.renderdata.udwantedangle[i] = (float)(this.renderdata.udwantedangle[i] - 6.283185307179586D));
/*  368 */       for (; this.renderdata.udwantedangle[i] < -3.141592653589793D; this.renderdata.udwantedangle[i] = (float)(this.renderdata.udwantedangle[i] + 6.283185307179586D));
/*  369 */       double rhm = this.renderdata.udwantedangle[i];
/*  370 */       double rhdir = this.renderdata.udcurrentangle[i];
/*      */ 
/*      */       
/*  373 */       double rdv = (rhm - rhdir) % 6.283185307179586D;
/*  374 */       for (; rdv > Math.PI; rdv -= 6.283185307179586D);
/*  375 */       for (; rdv < -3.141592653589793D; rdv += 6.283185307179586D);
/*  376 */       diff = (float)rdv;
/*      */ 
/*      */ 
/*      */       
/*  380 */       this.renderdata.udvelocity[i] = getNewVelocity(realv * 2.0F, diff, this.renderdata.udvelocity[i]);
/*  381 */       if (this.renderdata.udvelocity[i] == 0.0F || Math.abs(diff) < 0.03490658503988659D) {
/*  382 */         this.renderdata.uppoint[i] = 0.0F;
/*  383 */         fcount++;
/*      */       } 
/*  385 */       rhdir += this.renderdata.udvelocity[i];
/*      */       
/*  387 */       for (; rhdir > Math.PI; rhdir -= 6.283185307179586D);
/*  388 */       for (; rhdir < -3.141592653589793D; rhdir += 6.283185307179586D);
/*      */       
/*  390 */       dd = this.renderdata.udcurrentangle[i] = (float)rhdir;
/*  391 */       this.renderdata.uddisplayangle[i] = dd;
/*      */ 
/*      */       
/*  394 */       d1 = this.renderdata.realposx[i] - this.renderdata.foot_xpos[i];
/*  395 */       d3 = this.renderdata.realposz[i] - this.renderdata.foot_zpos[i];
/*  396 */       dd = (float)Math.atan2(d3, d1);
/*  397 */       this.renderdata.ywantedangle[i] = dd; rhm = dd;
/*  398 */       rhdir = this.renderdata.ycurrentangle[i];
/*      */ 
/*      */       
/*  401 */       rdv = (rhm - rhdir) % 6.283185307179586D;
/*  402 */       if (rdv > Math.PI) rdv -= 6.283185307179586D; 
/*  403 */       if (rdv < -3.141592653589793D) rdv += 6.283185307179586D; 
/*  404 */       diff = (float)rdv;
/*      */       
/*  406 */       this.renderdata.yvelocity[i] = getNewVelocity(realv, diff, this.renderdata.yvelocity[i]);
/*  407 */       if (this.renderdata.yvelocity[i] == 0.0F || Math.abs(diff) < 0.03490658503988659D) fcount++; 
/*  408 */       this.renderdata.ycurrentangle[i] = this.renderdata.ycurrentangle[i] + this.renderdata.yvelocity[i];
/*  409 */       for (; this.renderdata.ycurrentangle[i] > Math.PI; this.renderdata.ycurrentangle[i] = (float)(this.renderdata.ycurrentangle[i] - 6.283185307179586D));
/*  410 */       for (; this.renderdata.ycurrentangle[i] < -3.141592653589793D; this.renderdata.ycurrentangle[i] = (float)(this.renderdata.ycurrentangle[i] + 6.283185307179586D));
/*      */ 
/*      */       
/*  413 */       dd = (float)(this.renderdata.ycurrentangle[i] - Math.toRadians(MathHelper.wrapAngleTo180_double(this.rotationYaw)) - 1.5707963267948966D);
/*  414 */       for (; dd > Math.PI; dd = (float)(dd - 6.283185307179586D));
/*  415 */       for (; dd < -3.141592653589793D; dd = (float)(dd + 6.283185307179586D));
/*  416 */       this.renderdata.ydisplayangle[i] = dd;
/*      */       
/*  418 */       if (fcount == 3) {
/*  419 */         this.renderdata.footup[i] = 0;
/*  420 */         Block bid = this.worldObj.getBlock((int)this.renderdata.foot_xpos[i], (int)this.renderdata.foot_ypos[i], (int)this.renderdata.foot_zpos[i]);
/*  421 */         if (bid == Blocks.tallgrass && this.riddenByEntity != null && 
/*  422 */           this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock((int)this.renderdata.foot_xpos[i], (int)this.renderdata.foot_ypos[i], (int)this.renderdata.foot_zpos[i], Blocks.air);
/*      */         
/*  424 */         bid = this.worldObj.getBlock((int)this.renderdata.foot_xpos[i], (int)this.renderdata.foot_ypos[i] - 1, (int)this.renderdata.foot_zpos[i]);
/*  425 */         if (bid == Blocks.grass && this.riddenByEntity != null && 
/*  426 */           this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock((int)this.renderdata.foot_xpos[i], (int)this.renderdata.foot_ypos[i] - 1, (int)this.renderdata.foot_zpos[i], Blocks.dirt);
/*      */       
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void findNewFooting(int i) {
/*  437 */     float f = 16.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  442 */     int found = 0;
/*      */ 
/*      */     
/*  445 */     float range = 0.0F;
/*      */     
/*  447 */     double rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */     
/*  449 */     double pi = 3.1415926545D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  456 */     this.renderdata.footingticker[i] = 0;
/*      */     
/*  458 */     float d1 = (float)(this.posX - this.prevPosX);
/*  459 */     float d3 = (float)(this.posZ - this.prevPosZ);
/*  460 */     double rhm = Math.atan2(d3, d1);
/*  461 */     double velocity = Math.sqrt((d1 * d1 + d3 * d3));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  467 */     double rdv = Math.abs(rhm - rhdir) % pi * 2.0D;
/*  468 */     if (rdv > pi) rdv -= pi * 2.0D; 
/*  469 */     rdv = Math.abs(rdv);
/*  470 */     if (Math.abs(velocity) < 0.01D) rdv = 0.0D; 
/*  471 */     range = this.renderdata.yrange[i];
/*  472 */     range *= 0.875F;
/*  473 */     if (Math.abs((this.prevRotationYaw - this.rotationYaw) % 360.0F) > 0.75F) range = 0.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  478 */     if (i >= 4) f = 10.0F; 
/*  479 */     if (rdv > 1.5D) {
/*      */       
/*  481 */       range = -range;
/*  482 */       f = 10.0F;
/*  483 */       if (i >= 4) f = 16.0F;
/*      */     
/*      */     } 
/*      */ 
/*      */     
/*  488 */     float fx = (float)(this.renderdata.realposx[i] - (f / 2.0F) * Math.sin(Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0F))) + this.renderdata.ymid[i])), deffx = fx;
/*  489 */     float fz = (float)(this.renderdata.realposz[i] + (f / 2.0F) * Math.cos(Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0F))) + this.renderdata.ymid[i])), deffz = fz;
/*  490 */     float fy = this.renderdata.realposy[i] - 1.0F, deffy = fy;
/*  491 */     float oldf = f;
/*  492 */     int span = 1;
/*  493 */     while (found == 0 && f > 3.5F) {
/*  494 */       fx = (float)(this.renderdata.realposx[i] - f * Math.sin(Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0F))) + this.renderdata.ymid[i] - range));
/*  495 */       fz = (float)(this.renderdata.realposz[i] + f * Math.cos(Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0F))) + this.renderdata.ymid[i] - range));
/*  496 */       fy = this.renderdata.realposy[i];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  521 */       for (int j = 11; found == 0 && j > -14; j--) {
/*  522 */         for (int m = -span; found == 0 && m <= span; m++) {
/*  523 */           for (int n = -span; found == 0 && n <= span; n++) {
/*  524 */             Block blk = this.worldObj.getBlock((int)fx + m, (int)fy + j, (int)fz + n);
/*  525 */             if (blk != Blocks.air && 
/*  526 */               this.worldObj.getBlock((int)fx + m, (int)fy + j, (int)fz + n).getMaterial().isSolid()) {
/*  527 */               fy += (j + 1);
/*  528 */               fx += m;
/*  529 */               fz += n;
/*  530 */               found = 1;
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/*  538 */       if (found == 1) {
/*  539 */         d1 = this.renderdata.realposx[i] - fx;
/*  540 */         float d2 = this.renderdata.realposy[i] - fy;
/*  541 */         d3 = this.renderdata.realposz[i] - fz;
/*  542 */         float dd = (float)Math.sqrt((d1 * d1 + d2 * d2 + d3 * d3));
/*  543 */         dd *= 16.0F;
/*  544 */         if (dd > 294.0F) {
/*  545 */           found = 0;
/*      */         }
/*      */       } 
/*  548 */       f--;
/*  549 */       if (f < 3.5F && 
/*  550 */         range != 0.0F) {
/*  551 */         range = 0.0F;
/*  552 */         span = 3;
/*  553 */         f = oldf;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  561 */     if (found == 0) {
/*  562 */       fx = deffx;
/*  563 */       fy = deffy;
/*  564 */       fz = deffz;
/*      */     } 
/*      */     
/*  567 */     float sfx = this.renderdata.foot_xpos[i];
/*  568 */     float sfy = this.renderdata.foot_ypos[i];
/*  569 */     float sfz = this.renderdata.foot_zpos[i];
/*  570 */     this.renderdata.foot_xpos[i] = fx;
/*  571 */     this.renderdata.foot_ypos[i] = fy;
/*  572 */     this.renderdata.foot_zpos[i] = fz;
/*      */ 
/*      */     
/*  575 */     if (this.renderdata.footup[i] == 0) {
/*  576 */       this.renderdata.footup[i] = 1;
/*      */       
/*  578 */       d1 = sfx - fx;
/*  579 */       float d2 = sfy - fy;
/*  580 */       d3 = sfz - fz;
/*  581 */       float dd = (float)Math.sqrt((d1 * d1 + d2 * d2 + d3 * d3));
/*  582 */       dd *= 16.0F;
/*  583 */       d1 = (sfy + fy) / 2.0F;
/*  584 */       if (dd > 3.0F) {
/*  585 */         d1++;
/*      */       }
/*  587 */       if (dd > 48.0F) {
/*  588 */         d1 += 1.5F;
/*      */       }
/*  590 */       if (dd > 100.0F) {
/*  591 */         d1 += 1.5F;
/*      */       }
/*  593 */       this.renderdata.uppoint[i] = d1;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean shouldRiderSit() {
/*  605 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getTrackingRange() {
/*  610 */     return 128;
/*      */   }
/*      */   
/*      */   public int getUpdateFrequency() {
/*  614 */     return 10;
/*      */   }
/*      */   
/*      */   public boolean sendsVelocityUpdates() {
/*  618 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canTriggerWalking() {
/*  631 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void entityInit() {
/*  637 */     super.entityInit();
/*  638 */     enablePersistence();
/*  639 */     initLegData();
/*  640 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RenderSpiderRobotInfo getRenderSpiderRobotInfo() {
/*  647 */     return this.renderdata;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBePushed() {
/*  656 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getMountedYOffset() {
/*  664 */     if (this.riddenByEntity != null && this.riddenByEntity instanceof SpiderDriver) return 2.0D; 
/*  665 */     return 2.625D + Math.cos((this.rideTicker * 0.19F)) * 0.02D;
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateRiderPosition() {
/*  670 */     if (this.riddenByEntity != null) {
/*      */       
/*  672 */       float f = -3.0F;
/*  673 */       f = (float)(f + Math.cos((this.rideTicker * 0.33F)) * 0.05D);
/*  674 */       this.riddenByEntity.setPosition(this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/*  688 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/*  689 */       return false;
/*      */     }
/*  691 */     if (par1DamageSource.getDamageType().equals("cactus")) {
/*  692 */       return false;
/*      */     }
/*  694 */     if (par1DamageSource.getDamageType().equals("inFire")) {
/*  695 */       return false;
/*      */     }
/*  697 */     if (par1DamageSource.getDamageType().equals("onFire")) {
/*  698 */       return false;
/*      */     }
/*  700 */     if (par1DamageSource.getDamageType().equals("magic")) {
/*  701 */       return false;
/*      */     }
/*  703 */     if (par1DamageSource.getDamageType().equals("starve")) {
/*  704 */       return false;
/*      */     }
/*      */     
/*  707 */     return super.attackEntityFrom(par1DamageSource, par2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void fall(float par1) {}
/*      */ 
/*      */   
/*      */   protected void updateFallState(double par1, boolean par3) {}
/*      */ 
/*      */   
/*      */   public boolean canBeCollidedWith() {
/*  719 */     return !this.isDead;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
/*  731 */     if (this.riddenByEntity != null) {
/*      */       
/*  733 */       this.boatPosRotationIncrements = par9 + 8;
/*      */     }
/*      */     else {
/*      */       
/*  737 */       this.boatPosRotationIncrements = par9 + 6;
/*      */     } 
/*      */ 
/*      */     
/*  741 */     this.boatX = par1;
/*  742 */     this.boatY = par3;
/*  743 */     this.boatZ = par5;
/*  744 */     this.boatYaw = par7;
/*  745 */     this.boatPitch = par8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void setVelocity(double par1, double par3, double par5) {
/*  756 */     if (this.riddenByEntity == null) {
/*  757 */       super.setVelocity(par1, par3, par5);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onUpdate() {
/*  762 */     super.onUpdate();
/*  763 */     setFire(0);
/*  764 */     if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && !this.worldObj.isRemote && this.riddenByEntity != null && this.worldObj.rand.nextInt(40) == 0) {
/*  765 */       feetFindSomethingToHit();
/*      */     }
/*      */     
/*  768 */     if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && !this.worldObj.isRemote && this.riddenByEntity != null && this.worldObj.rand.nextInt(15) == 0) {
/*  769 */       EntityLivingBase e = null;
/*  770 */       e = findSomethingToAttack();
/*  771 */       if (e != null) {
/*  772 */         if (getDistanceSqToEntity((Entity)e) < ((12.0F + e.width / 2.0F) * (12.0F + e.width / 2.0F))) {
/*  773 */           setAttacking(1);
/*  774 */           attackEntityAsMob((Entity)e);
/*      */         } 
/*      */       } else {
/*  777 */         setAttacking(0);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  782 */     float f = 8.0F;
/*      */     
/*  784 */     float dx = (float)(f * Math.cos(Math.toRadians((this.rotationYaw - 90.0F))));
/*  785 */     float dz = (float)(f * Math.sin(Math.toRadians((this.rotationYaw - 90.0F))));
/*      */     
/*  787 */     if (this.worldObj.rand.nextInt(8) == 0) {
/*  788 */       this.worldObj.spawnParticle("flame", this.posX + dx, this.posY + 2.0D, this.posZ + dz, (dx / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 10.0F), (dz / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  794 */     if (this.worldObj.rand.nextInt(2) == 0) {
/*  795 */       this.worldObj.spawnParticle("smoke", this.posX + dx, this.posY + 2.0D, this.posZ + dz, (dx / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 10.0F), (dz / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  801 */     if (this.worldObj.rand.nextInt(10) == 0) {
/*  802 */       this.worldObj.spawnParticle("fireworksSpark", this.posX + dx, this.posY + 2.0D, this.posZ + dz, (dx / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0F), (dz / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onLivingUpdate() {
/*  817 */     List list = null;
/*  818 */     double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */ 
/*      */     
/*  821 */     double d6 = (this.rand.nextFloat() * 2.0F - 1.0F);
/*  822 */     double d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  828 */     double obstruction_factor = 0.0D;
/*      */     
/*  830 */     double relative_g = 0.0D;
/*      */     
/*  832 */     double max_speed = 0.45D;
/*  833 */     double gh = 1.55D;
/*      */     
/*  835 */     int dist = 2;
/*      */ 
/*      */     
/*  838 */     if (this.isDead)
/*      */       return; 
/*  840 */     if (this.riddenByEntity == null) {
/*  841 */       super.onLivingUpdate();
/*      */     }
/*  843 */     if (this.motionY > 0.8500000238418579D) this.motionY = 0.8500000238418579D; 
/*  844 */     if (this.motionY < -0.8500000238418579D) this.motionY = -0.8500000238418579D; 
/*  845 */     if (this.motionX < -1.25D) this.motionX = -1.25D; 
/*  846 */     if (this.motionX > 1.25D) this.motionX = 1.25D; 
/*  847 */     if (this.motionZ < -1.25D) this.motionZ = -1.25D; 
/*  848 */     if (this.motionZ > 1.25D) this.motionZ = 1.25D;
/*      */     
/*  850 */     this.prevPosX = this.posX;
/*  851 */     this.prevPosY = this.posY;
/*  852 */     this.prevPosZ = this.posZ;
/*      */     
/*  854 */     this.rideTicker += this.worldObj.rand.nextInt(3);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  859 */     if (this.playing > 0) this.playing--; 
/*  860 */     if (this.riddenByEntity != null && this.playing == 0 && this.worldObj.rand.nextInt(80) == 1) {
/*  861 */       this.worldObj.playSoundAtEntity((Entity)this, "orespawn:robotspider", 0.45F, 1.0F);
/*  862 */       this.playing = 125;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  869 */     if (this.worldObj.isRemote) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  874 */       if (this.riddenByEntity == null) {
/*  875 */         Block bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh + 1.0F), (int)this.posZ);
/*  876 */         if (bid == Blocks.air) bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh), (int)this.posZ); 
/*  877 */         if (bid != Blocks.air && bid != Blocks.water && bid != Blocks.flowing_water && bid != Blocks.lava && bid != Blocks.flowing_lava) {
/*  878 */           this.motionY += 0.12D;
/*  879 */           this.posY += 0.12D;
/*  880 */           this.boatY += 0.12D;
/*      */         } else {
/*  882 */           this.motionY -= 0.002D;
/*      */         }
/*      */       
/*  885 */       } else if (this.riddenByEntity instanceof EntityPlayer) {
/*  886 */         EntityClientPlayerMP pp = (EntityClientPlayerMP)this.riddenByEntity;
/*  887 */         pp.sendQueue.addToSendQueue((Packet)new C03PacketPlayer.C05PacketPlayerLook(pp.rotationYaw, pp.rotationPitch, pp.onGround));
/*  888 */         pp.sendQueue.addToSendQueue((Packet)new C0CPacketInput(pp.moveStrafing, pp.moveForward, pp.movementInput.jump, pp.movementInput.sneak));
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  896 */       if (this.boatPosRotationIncrements > 0) {
/*      */         
/*  898 */         double d4 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
/*  899 */         double d5 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
/*  900 */         double d11 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
/*  901 */         setPosition(d4, d5, d11);
/*      */         
/*  903 */         this.rotationPitch = (float)(this.rotationPitch + (this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
/*  904 */         double d10 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
/*  905 */         if (this.riddenByEntity != null) d10 = MathHelper.wrapAngleTo180_double(this.riddenByEntity.rotationYaw - this.rotationYaw);
/*      */         
/*  907 */         this.rotationYaw = (float)(this.rotationYaw + d10 / this.boatPosRotationIncrements);
/*  908 */         setRotation(this.rotationYaw, this.rotationPitch);
/*      */         
/*  910 */         this.boatPosRotationIncrements--;
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */ 
/*      */         
/*  918 */         double d4 = this.posX + this.motionX;
/*  919 */         double d5 = this.posY + this.motionY;
/*  920 */         double d11 = this.posZ + this.motionZ;
/*  921 */         setPosition(d4, d5, d11);
/*      */ 
/*      */ 
/*      */         
/*  925 */         this.motionX *= 0.99D;
/*  926 */         this.motionY *= 0.95D;
/*  927 */         this.motionZ *= 0.99D;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  933 */       updateLegs();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  947 */       if (this.riddenByEntity != null) {
/*  948 */         gh = 4.25D;
/*  949 */         Block bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh), (int)this.posZ);
/*  950 */         if (bid != Blocks.air && bid != Blocks.water && bid != Blocks.flowing_water && bid != Blocks.lava && bid != Blocks.flowing_lava) {
/*  951 */           this.motionY += 0.06D;
/*  952 */           this.posY += 0.03D;
/*      */         } else {
/*  954 */           this.motionY -= 0.02D;
/*      */         } 
/*      */       } else {
/*  957 */         Block bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh + 1.0F), (int)this.posZ);
/*  958 */         if (bid == Blocks.air) bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh), (int)this.posZ); 
/*  959 */         if (bid != Blocks.air && bid != Blocks.water && bid != Blocks.flowing_water && bid != Blocks.lava && bid != Blocks.flowing_lava) {
/*  960 */           this.motionY += 0.15D;
/*  961 */           this.posY += 0.15D;
/*  962 */           this.boatY += 0.15D;
/*      */         } else {
/*  964 */           this.motionY -= 0.002D;
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  971 */       if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer) {
/*  972 */         EntityPlayer pp = (EntityPlayer)this.riddenByEntity;
/*      */         
/*  974 */         obstruction_factor = 0.0D;
/*  975 */         dist = 3;
/*  976 */         dist += (int)(velocity * 6.0D);
/*      */         
/*  978 */         for (int k = 1; k < dist; k++) {
/*  979 */           for (int i = 1; i < dist * 3; i++) {
/*  980 */             for (int j = -90; j <= 90; j += 30) {
/*  981 */               double dx = i * Math.cos(Math.toRadians((this.rotationYaw + 90.0F + j)));
/*  982 */               double dz = i * Math.sin(Math.toRadians((this.rotationYaw + 90.0F + j)));
/*  983 */               Block block = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY - k, (int)(this.posZ + dz));
/*  984 */               if (block != Blocks.air && block != Blocks.water && block != Blocks.flowing_water && block != Blocks.lava && block != Blocks.flowing_lava) {
/*  985 */                 obstruction_factor += 0.03D;
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  993 */         this.motionY += obstruction_factor * 0.05D;
/*  994 */         this.posY += obstruction_factor * 0.05D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1003 */         double d4 = this.riddenByEntity.rotationYaw;
/* 1004 */         d4 %= 360.0D;
/* 1005 */         for (; d4 < 0.0D; d4 += 360.0D);
/* 1006 */         double d5 = this.rotationYaw;
/* 1007 */         d5 %= 360.0D;
/* 1008 */         for (; d5 < 0.0D; d5 += 360.0D);
/* 1009 */         relative_g = (d4 - d5) % 180.0D;
/* 1010 */         for (; relative_g < 0.0D; relative_g += 180.0D);
/* 1011 */         if (relative_g > 90.0D) relative_g -= 180.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1018 */         if (velocity > 0.01D) {
/*      */           
/* 1020 */           d4 = 1.85D - velocity;
/* 1021 */           d4 = Math.abs(d4);
/* 1022 */           if (d4 < 0.01D) d4 = 0.01D; 
/* 1023 */           if (d4 > 0.9D) d4 = 0.9D; 
/* 1024 */           this.rotationYaw = this.riddenByEntity.rotationYaw + (float)(relative_g * d4);
/*      */         } else {
/*      */           
/* 1027 */           this.rotationYaw = this.riddenByEntity.rotationYaw;
/*      */         } 
/* 1029 */         relative_g = Math.abs(relative_g) * velocity;
/* 1030 */         if (relative_g > 50.0D) relative_g = 0.0D;
/*      */ 
/*      */ 
/*      */         
/* 1034 */         this.rotationPitch = 0.0F;
/* 1035 */         setRotation(this.rotationYaw, this.rotationPitch);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1041 */         double newvelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1049 */         double rr = Math.atan2(this.riddenByEntity.motionZ, this.riddenByEntity.motionX);
/* 1050 */         double rhm = Math.atan2(this.motionZ, this.motionX);
/* 1051 */         double rhdir = Math.toRadians(((this.riddenByEntity.rotationYaw + 90.0F) % 360.0F));
/* 1052 */         double rt = 0.0D;
/*      */         
/* 1054 */         double pi = 3.1415926545D;
/* 1055 */         double deltav = 0.0D;
/* 1056 */         float im = pp.moveForward;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1061 */         double rdv = Math.abs(rhm - rhdir) % pi * 2.0D;
/* 1062 */         if (rdv > pi) rdv -= pi * 2.0D; 
/* 1063 */         rdv = Math.abs(rdv);
/* 1064 */         if (Math.abs(newvelocity) < 0.01D) rdv = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1072 */         if (rdv > 1.5D) newvelocity = -newvelocity;
/*      */         
/* 1074 */         if (Math.abs(im) > 0.001F) {
/* 1075 */           if (im > 0.0F) {
/* 1076 */             deltav = 0.05D;
/*      */           } else {
/*      */             
/* 1079 */             max_speed = 0.25D;
/*      */             
/* 1081 */             deltav = -0.05D;
/*      */           } 
/*      */           
/* 1084 */           newvelocity += deltav;
/* 1085 */           if (newvelocity >= 0.0D) {
/* 1086 */             if (newvelocity > max_speed) newvelocity = max_speed; 
/* 1087 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 1088 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*      */           } else {
/* 1090 */             if (newvelocity < -max_speed) newvelocity = -max_speed; 
/* 1091 */             newvelocity = -newvelocity;
/* 1092 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/* 1093 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/*      */           }
/*      */         
/*      */         }
/* 1097 */         else if (newvelocity >= 0.0D) {
/* 1098 */           this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 1099 */           this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*      */         } else {
/* 1101 */           this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/* 1102 */           this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/*      */         } 
/*      */ 
/*      */         
/* 1106 */         moveEntity(this.motionX, this.motionY, this.motionZ);
/* 1107 */         this.motionX *= 0.98D;
/* 1108 */         this.motionY *= 0.98D;
/* 1109 */         this.motionZ *= 0.98D;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1114 */       moveEntity(this.motionX, this.motionY, this.motionZ);
/* 1115 */       this.motionX *= 0.8D;
/* 1116 */       this.motionY *= 0.98D;
/* 1117 */       this.motionZ *= 0.8D;
/*      */ 
/*      */       
/* 1120 */       if (this.riddenByEntity != null && this.riddenByEntity.isDead)
/*      */       {
/* 1122 */         this.riddenByEntity = null;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void goThisWay(double mx, double mz) {
/* 1131 */     this.motionX = mx;
/* 1132 */     this.motionZ = mz;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAIEnabled() {
/* 1140 */     if (this.riddenByEntity != null) return false; 
/* 1141 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public float getShadowSize() {
/* 1157 */     return 0.95F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 1165 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*      */     
/* 1167 */     if (var2 != null && 
/* 1168 */       var2.stackSize <= 0) {
/* 1169 */       par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 1170 */       var2 = null;
/*      */     } 
/*      */ 
/*      */     
/* 1174 */     if (var2 != null && var2.getItem() == Items.iron_ingot && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) {
/*      */       
/* 1176 */       if (!this.worldObj.isRemote) {
/*      */         
/* 1178 */         float f = getMaxHealth() - getHealth();
/* 1179 */         if (f > 100.0F) {
/* 1180 */           f = 100.0F;
/*      */         }
/* 1182 */         if (f > 0.0F) heal(f);
/*      */       
/*      */       } 
/* 1185 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/* 1187 */         var2.stackSize--;
/* 1188 */         if (var2.stackSize <= 0)
/*      */         {
/* 1190 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/* 1193 */       return true;
/*      */     } 
/*      */     
/* 1196 */     if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != par1EntityPlayer)
/*      */     {
/* 1198 */       return true;
/*      */     }
/*      */ 
/*      */     
/* 1202 */     if (!this.worldObj.isRemote && this.riddenByEntity == null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*      */       
/* 1204 */       par1EntityPlayer.mountEntity((Entity)this);
/*      */       
/* 1206 */       this.worldObj.playSoundAtEntity((Entity)this, "orespawn:robotspidermount", 0.65F, 1.0F);
/*      */     } 
/*      */     
/* 1209 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void feetFindSomethingToHit() {
/* 1215 */     if (OreSpawnMain.PlayNicely != 0)
/* 1216 */       return;  List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(20.0D, 8.0D, 20.0D));
/* 1217 */     Iterator<Entity> var2 = var5.iterator();
/* 1218 */     Entity var3 = null;
/* 1219 */     EntityLivingBase var4 = null;
/*      */     
/* 1221 */     while (var2.hasNext()) {
/*      */       
/* 1223 */       var3 = var2.next();
/* 1224 */       var4 = (EntityLivingBase)var3;
/*      */       
/* 1226 */       if (feetisSuitableTarget(var4, false))
/*      */       {
/* 1228 */         feetattackEntityAsMob((Entity)var4);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean feetisSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 1236 */     if (par1EntityLiving == null)
/*      */     {
/* 1238 */       return false;
/*      */     }
/* 1240 */     if (par1EntityLiving == this)
/*      */     {
/* 1242 */       return false;
/*      */     }
/* 1244 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/* 1246 */       return false;
/*      */     }
/* 1248 */     if (par1EntityLiving instanceof SpiderRobot)
/*      */     {
/* 1250 */       return false;
/*      */     }
/* 1252 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntitySpider)
/*      */     {
/* 1254 */       return false;
/*      */     }
/* 1256 */     if (par1EntityLiving instanceof SpiderDriver)
/*      */     {
/* 1258 */       return false;
/*      */     }
/* 1260 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityCaveSpider)
/*      */     {
/* 1262 */       return false;
/*      */     }
/* 1264 */     if (par1EntityLiving == this.riddenByEntity) return false;
/*      */     
/* 1266 */     float d1 = (float)(par1EntityLiving.posX - this.posX);
/* 1267 */     float d2 = (float)(par1EntityLiving.posY - this.posY);
/* 1268 */     float d3 = (float)(par1EntityLiving.posZ - this.posZ);
/* 1269 */     float dd = (float)Math.sqrt((d1 * d1 + d2 * d2 + d3 * d3));
/*      */     
/* 1271 */     if (dd > 18.0F) return false; 
/* 1272 */     if (dd < 12.0F) return false;
/*      */     
/* 1274 */     if (par1EntityLiving instanceof EntityPlayer) {
/*      */       
/* 1276 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 1277 */       if (p.capabilities.isCreativeMode == true) {
/* 1278 */         return false;
/*      */       }
/* 1280 */       return true;
/*      */     } 
/*      */ 
/*      */     
/* 1284 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean feetattackEntityAsMob(Entity par1Entity) {
/* 1289 */     boolean ret = false;
/* 1290 */     if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*      */       
/* 1292 */       double ks = 0.6D;
/* 1293 */       double inair = 0.1D;
/* 1294 */       float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 1295 */       ret = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), OreSpawnMain.SpiderRobot_stats.attack / 10.0F);
/* 1296 */       if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 1297 */       if (ret) par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks); 
/*      */     } 
/* 1299 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private EntityLivingBase findSomethingToAttack() {
/* 1305 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 1306 */     List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(20.0D, 12.0D, 20.0D));
/* 1307 */     Iterator<Entity> var2 = var5.iterator();
/* 1308 */     Entity var3 = null;
/* 1309 */     EntityLivingBase var4 = null;
/*      */     
/* 1311 */     while (var2.hasNext()) {
/*      */       
/* 1313 */       var3 = var2.next();
/* 1314 */       var4 = (EntityLivingBase)var3;
/*      */       
/* 1316 */       if (isSuitableTarget(var4, false))
/*      */       {
/* 1318 */         return var4;
/*      */       }
/*      */     } 
/* 1321 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 1328 */     if (par1EntityLiving == null)
/*      */     {
/* 1330 */       return false;
/*      */     }
/* 1332 */     if (par1EntityLiving == this)
/*      */     {
/* 1334 */       return false;
/*      */     }
/* 1336 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/* 1338 */       return false;
/*      */     }
/* 1340 */     if (par1EntityLiving instanceof SpiderRobot)
/*      */     {
/* 1342 */       return false;
/*      */     }
/* 1344 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntitySpider)
/*      */     {
/* 1346 */       return false;
/*      */     }
/* 1348 */     if (par1EntityLiving instanceof SpiderDriver)
/*      */     {
/* 1350 */       return false;
/*      */     }
/* 1352 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityCaveSpider)
/*      */     {
/* 1354 */       return false;
/*      */     }
/* 1356 */     if (par1EntityLiving == this.riddenByEntity) return false;
/*      */     
/* 1358 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*      */     
/* 1360 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/*      */       
/* 1363 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1367 */     double rr = Math.atan2(par1EntityLiving.posZ - this.posZ, par1EntityLiving.posX - this.posX);
/* 1368 */     double rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */     
/* 1370 */     double pi = 3.1415926545D;
/*      */     
/* 1372 */     double rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/* 1373 */     if (rdd > pi) rdd -= pi * 2.0D; 
/* 1374 */     rdd = Math.abs(rdd);
/*      */ 
/*      */     
/* 1377 */     if (getDistanceSqToEntity((Entity)par1EntityLiving) < 36.0D) return true; 
/* 1378 */     if (rdd > 0.75D) {
/* 1379 */       return false;
/*      */     }
/* 1381 */     if (par1EntityLiving instanceof EntityPlayer) {
/*      */       
/* 1383 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 1384 */       if (p.capabilities.isCreativeMode == true) {
/* 1385 */         return false;
/*      */       }
/* 1387 */       return true;
/*      */     } 
/*      */     
/* 1390 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 1395 */     boolean ret = false;
/* 1396 */     if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*      */       
/* 1398 */       double ks = 1.2D;
/* 1399 */       double inair = 0.15D;
/* 1400 */       float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 1401 */       ret = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), OreSpawnMain.SpiderRobot_stats.attack);
/* 1402 */       if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 1403 */       if (ret) par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks); 
/*      */     } 
/* 1405 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAttacking() {
/* 1411 */     return this.dataWatcher.getWatchableObjectByte(20);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAttacking(int par1) {
/* 1416 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*      */   }
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/* 1421 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private ItemStack dropItemRand(Item index, int par1) {
/* 1426 */     EntityItem var3 = null;
/* 1427 */     ItemStack is = new ItemStack(index, par1, 0);
/*      */     
/* 1429 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
/*      */     
/* 1431 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 1432 */     return is;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/* 1440 */     ItemStack is = null;
/*      */ 
/*      */     
/* 1443 */     int i = 14 + this.worldObj.rand.nextInt(14);
/* 1444 */     for (int var4 = 0; var4 < i; var4++) {
/* 1445 */       int var3 = this.worldObj.rand.nextInt(15);
/* 1446 */       switch (var3) {
/*      */         case 0:
/* 1448 */           is = dropItemRand(Items.redstone, 1);
/*      */           break;
/*      */         case 1:
/* 1451 */           is = dropItemRand(Items.repeater, 1);
/*      */           break;
/*      */         case 2:
/* 1454 */           is = dropItemRand(Items.comparator, 1);
/*      */           break;
/*      */         case 3:
/* 1457 */           is = dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
/*      */           break;
/*      */         case 4:
/* 1460 */           is = dropItemRand(Item.getItemFromBlock(Blocks.dispenser), 1);
/*      */           break;
/*      */         case 5:
/* 1463 */           is = dropItemRand(Item.getItemFromBlock((Block)Blocks.sticky_piston), 1);
/*      */           break;
/*      */         case 6:
/* 1466 */           is = dropItemRand(Item.getItemFromBlock((Block)Blocks.piston), 1);
/*      */           break;
/*      */         case 7:
/* 1469 */           is = dropItemRand(Item.getItemFromBlock(Blocks.lever), 1);
/*      */           break;
/*      */         case 8:
/* 1472 */           is = dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
/*      */           break;
/*      */         case 9:
/* 1475 */           is = dropItemRand(Item.getItemFromBlock(Blocks.light_weighted_pressure_plate), 1);
/*      */           break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\SpiderRobot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */