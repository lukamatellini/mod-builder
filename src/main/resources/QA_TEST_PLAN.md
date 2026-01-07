# QA Test Plan: Fortune & Follies

Generated: 2026-01-07T02:13:32.887Z
Minecraft Version: 1.21.1
Mod ID: fortunefollies

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 41 |
| Passed | 35 |
| Failed | 1 |
| Warnings | 2 |
| Skipped | 3 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `fortunefollies.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Lucky Block | `/give @p fortunefollies:lucky_block_item` | ☐ | ☐ | ☐ |
| Zombie | `/give @p fortunefollies:zombie` | ☐ | ☐ | ☐ |
| Creeper | `/give @p fortunefollies:creeper` | ☐ | ☐ | ☐ |
| Explosion Small | `/give @p fortunefollies:explosion_small` | ☐ | ☐ | ☐ |
| Regeneration | `/give @p fortunefollies:regeneration` | ☐ | ☐ | ☐ |
| Poison | `/give @p fortunefollies:poison` | ☐ | ☐ | ☐ |
| Experience Orb | `/give @p fortunefollies:experience_orb` | ☐ | ☐ | ☐ |

### Item Tests

#### Lucky Block

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lucky Block"
- [ ] Crafting recipe works

#### Zombie

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Zombie"

#### Creeper

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Creeper"

#### Explosion Small

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Explosion Small"

#### Regeneration

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Regeneration"

#### Poison

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Poison"

#### Experience Orb

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Experience Orb"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p fortunefollies:lucky_block` | ☐ | ☐ | ☐ |

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
