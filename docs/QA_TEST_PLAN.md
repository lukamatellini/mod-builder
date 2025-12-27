# QA Test Plan: Ethereal Expanse

Generated: 2025-12-27T16:00:41.987Z
Minecraft Version: 1.21.1
Mod ID: etherealexpanse

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 57 |
| Passed | 54 |
| Failed | 0 |
| Warnings | 2 |
| Skipped | 1 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `etherealexpanse.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Ethereal Crystal | `/give @p etherealexpanse:ethereal_crystal` | ☐ | ☐ | ☐ |
| Void Compass | `/give @p etherealexpanse:void_compass` | ☐ | ☐ | ☐ |
| Anchor Boots | `/give @p etherealexpanse:anchor_boots` | ☐ | ☐ | ☐ |
| Void Expanse Portal Key | `/give @p etherealexpanse:void_expanse_portal_igniter` | ☐ | ☐ | ☐ |

### Item Tests

#### Ethereal Crystal

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Ethereal Crystal"
- [ ] Crafting recipe works

#### Void Compass

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Void Compass"
- [ ] Crafting recipe works

#### Anchor Boots

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Anchor Boots"
- [ ] Crafting recipe works

#### Void Expanse Portal Key

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Void Expanse Portal Key"
- [ ] Crafting recipe works
- [ ] Right-click action works: custom
- [ ] Cooldown applies (40 ticks)

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Voidstone | `/give @p etherealexpanse:voidstone` | ☐ | ☐ | ☐ |
| Ethereal Crystal Ore | `/give @p etherealexpanse:ethereal_crystal_ore` | ☐ | ☐ | ☐ |
| Gravity Anchor | `/give @p etherealexpanse:gravity_anchor` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Void Glider | `/summon etherealexpanse:void_glider` | ☐ | ☐ | ☐ |

### Mob Tests

#### Void Glider

- [ ] Spawns with `/summon etherealexpanse:void_glider`
- [ ] Has correct health: 10
- [ ] Deals expected damage: 5
- [ ] AI behavior works (passive)
- [ ] Drops loot on death:
  - [ ] ethereal_crystal (100% chance)

## Structures Checklist

### Void Expanse Obelisk
- [ ] Structure generates in world
- [ ] Use `/locate structure etherealexpanse:void_expanse_structure` to find
- [ ] Contains expected features

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
